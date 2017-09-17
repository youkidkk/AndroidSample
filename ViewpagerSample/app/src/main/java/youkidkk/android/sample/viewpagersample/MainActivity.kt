package youkidkk.android.sample.viewpagersample

import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private lateinit var pagerAdapter: FragmentPagerAdapter
    private var currentPage: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.viewPager = findViewById(R.id.viewPager) as ViewPager
        this.pagerAdapter = MainActivityPagerAdapter(supportFragmentManager)

        this.viewPager.adapter = this.pagerAdapter
        this.currentPage = 0
    }

}
