package kr.co.jinwook.lottieanimationtutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.LinearLayout
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2

class SliderImageViewActivity : AppCompatActivity() {

    var dotsLayout: LinearLayout? = null
    var adapter: SliderAdapter? = null
    var pager2: ViewPager2? = null
    lateinit var list: IntArray
    lateinit var dots: Array<TextView?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slider_image_view)
        dotsLayout = findViewById(R.id.dots_container)
        pager2 = findViewById(R.id.sliderImages)



        list = IntArray(5)
        list[0] = resources.getColor(R.color.black)
        list[1] = resources.getColor(R.color.lemonGreen)
        list[2] = resources.getColor(R.color.grey)
        list[3] = resources.getColor(R.color.mint_light)
        list[4] = resources.getColor(R.color.darkGrey)



        adapter = SliderAdapter(list)
        pager2?.setAdapter(adapter)
        dots = arrayOfNulls(5)
        dotsIndicator()
        pager2?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                selectedIndicator(position)
                super.onPageSelected(position)
            }
        })

    }

    private fun selectedIndicator(position: Int) {
        for (i in dots.indices) {
            if (i == position) {
                dots[i]!!.setTextColor(list[position])
            } else {
                dots[i]!!.setTextColor(resources.getColor(R.color.black))
            }
        }
    }

    private fun dotsIndicator() {
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#9679;")
            dots[i]!!.textSize = 18f
            dotsLayout!!.addView(dots[i])
        }
    }

}