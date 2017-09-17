package youkidkk.android.sample.fragmentsample

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ItemDetailFragment : Fragment() {

    private var textView: TextView? = null

    fun setContentAtIndex(newIndex: Int) {
        textView!!.text = MainActivity.contentArray[newIndex]
    }

    // ※savedInstanceState の型：Bundle は Nullable にする
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle? // 型：Bundle は Nullable にする
    ): View? {
        return inflater.inflate(R.layout.fragment_item_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        textView = activity.findViewById(R.id.detailTextView) as TextView
    }
}
