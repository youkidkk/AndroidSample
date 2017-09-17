package youkidkk.android.sample.fragmentsample

import android.app.FragmentManager
import android.app.FragmentTransaction
import android.app.ListFragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), ListSelectionListener {

    private val itemListFragment = ItemListFragment()
    private val itemDetailFragment = ItemDetailFragment()

    private lateinit var frgmManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frgmManager = getFragmentManager()

        titleArray = resources.getStringArray(R.array.Titles)
        contentArray = resources.getStringArray(R.array.Contents)

        val fragmentTransaction = fragmentManager!!.beginTransaction()

        fragmentTransaction.add(R.id.fragment, itemListFragment)

        fragmentTransaction.commit()
    }

    override fun onListSelection(index: Int) {
        val fragmentTransaction = fragmentManager!!.beginTransaction()

        fragmentTransaction.replace(R.id.fragment, itemDetailFragment)

        fragmentTransaction.addToBackStack(null)

        fragmentTransaction.commit()

        fragmentManager!!.executePendingTransactions()

        itemDetailFragment.setContentAtIndex(index)
    }

    companion object {

        lateinit var titleArray: Array<String>
        lateinit var contentArray: Array<String>
    }
}
