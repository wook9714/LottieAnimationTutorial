package kr.co.jinwook.lottieanimationtutorial

import TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import kotlinx.android.synthetic.main.activity_about_fragment.*
import kotlinx.android.synthetic.main.activity_about_fragment.head_layout00
import kotlinx.android.synthetic.main.activity_about_fragment.view.*
import kotlinx.android.synthetic.main.activity_test_xml_for_have_aseat.*

class About_Fragment_activity : AppCompatActivity() {

    val TAG : String = "로그"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_fragment)

        var viewPager = findViewById(R.id.view_pager00) as ViewPager
        var tabLayout = findViewById(R.id.tab_layout00) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(FragInfo(),"정보")
        fragmentAdapter.addFragment(FragMenu(),"메뉴")
        fragmentAdapter.addFragment(FragReview(),"리뷰")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

        fragmentAdapter.fragmenttitle


        scrollview00.run {
            header = head_layout00

            stickListener = { _ ->
                Log.d(TAG, "Stick Listener")
            }
            freeListener = { _ ->
                Log.d(TAG, "Free Listener")
            }
        }
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                head_layout00.callOnClick()
                Log.d(TAG,"About_Fragment_activity - onTabSelected() called")
            }
            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {
                head_layout00.callOnClick()
                Log.d(TAG,"About_Fragment_activity - onTabReselected() called")
            }
        })




    }



}



