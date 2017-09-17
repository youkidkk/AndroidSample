package youkidkk.android.sample.viewpagersample

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainActivityPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            1 -> FragmentB()
            2 -> FragmentC()
            else -> FragmentA()
        }

    }

    override fun getCount(): Int {
        return 3
    }
}
