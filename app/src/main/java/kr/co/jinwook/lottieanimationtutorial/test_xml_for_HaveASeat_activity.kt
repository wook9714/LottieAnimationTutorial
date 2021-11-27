package kr.co.jinwook.lottieanimationtutorial

import UIFunction
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import androidx.core.view.marginTop
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_test_xml_for_have_aseat.*

class test_xml_for_HaveASeat_activity : AppCompatActivity() {

    val TAG: String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_xml_for_have_aseat)



        var viewPager = findViewById(R.id.viewPager) as ViewPager
        var tabLayout = findViewById(R.id.tablayout) as TabLayout

        val fragmentAdapter = FragmentAdapter(supportFragmentManager)
        fragmentAdapter.addFragment(FragInfo(),"정보")
        fragmentAdapter.addFragment(FragMenu(),"메뉴")
        fragmentAdapter.addFragment(FragReview(),"리뷰")

        viewPager.adapter = fragmentAdapter
        tabLayout.setupWithViewPager(viewPager)

/*
<androidx.viewpager.widget.ViewPager
                android:layout_width="match_parent"
                android:layout_height="0dp"
                android:id="@+id/viewPager"
                android:layout_weight="1"

                />

*/
        UIFunction.makeStatusBarTransparent(window)


        main_scroll_view.run {
            header = header_view

            stickListener = { _ ->
                Log.d(TAG, "Stick Listener")
            }
            freeListener = { _ ->
                Log.d(TAG, "Free Listener")
            }


        }
    }
}