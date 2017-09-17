package youkidkk.android.sample.fragmentsample

import android.app.Activity
import android.app.ListFragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView

class ItemListFragment : ListFragment() {
    private var listener: ListSelectionListener? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? // 型：Bundle は Nullable にする
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onListItemClick(l: ListView, v: View, position: Int, id: Long) {
        super.onListItemClick(l, v, position, id)

        listener!!.onListSelection(position)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as ListSelectionListener
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        listener = activity as ListSelectionListener
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        listAdapter = ArrayAdapter(activity, R.layout.fragment_item_list, MainActivity.titleArray)

        listView.choiceMode = ListView.CHOICE_MODE_SINGLE
    }
}
