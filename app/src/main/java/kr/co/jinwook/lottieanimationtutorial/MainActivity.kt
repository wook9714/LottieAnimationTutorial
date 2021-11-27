package kr.co.jinwook.lottieanimationtutorial

import UIFunction
import android.animation.ValueAnimator
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kr.co.jinwook.lottieanimationtutorial.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import android.view.WindowManager

import android.os.Build
import android.view.ViewGroup
import android.view.Window
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_main.view.*


class MainActivity : AppCompatActivity() {

    val TAG : String = "로그"

    var isLiked :Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG,"MainActivity - onCreate() called")

        UIFunction.makeStatusBarTransparent(window)


    }

    override fun onStart() {
        //super : 기존 onstart의 로직을 발동시키겠다
        super.onStart()
        Log.d(TAG, "MainActivity - onStart() called")


    }

    override fun onResume() {
        super.onResume()  //엑티비티에서 가지고 있는 onResume을 실행한다.
        Log.d(TAG,"MainActivity - onResume() called")

        val animator = ValueAnimator.ofFloat(0.5f, 0.9f).setDuration(5)
        animator.addUpdateListener { animation: ValueAnimator ->
            like_btn.progress = animation.getAnimatedValue() as Float
        }
        animator.start()
        isLiked = false
        // TODO: 2021-10-19  빠르게 껐다킬 경우 MainActivity - onResume() called 는 됐지만 에니메이션이 꺼지지 않음


        brand_name.visibility = View.VISIBLE
        //brand_name.setText("Resume")


        isLiked = false

        //좋아요 버튼에 클릭리스너 달아줌줌
        like_btn.setOnClickListener {
            Log.d("asdf", "like_btn clicked")

            if (isLiked == false) {
                // Custom animation speed or duration.
                val animator = ValueAnimator.ofFloat(0f, 0.5f).setDuration(1500)
                animator.addUpdateListener { animation: ValueAnimator ->
                    like_btn.progress = animation.getAnimatedValue() as Float
                }
                animator.start()
                isLiked = true

            } else {

                val animator = ValueAnimator.ofFloat(0.5f, 1f).setDuration(500)
                animator.addUpdateListener { animation: ValueAnimator ->
                    like_btn.progress = animation.getAnimatedValue() as Float
                }
                animator.start()
                isLiked = false
            }
        }

        whenBrandLogoImageClicked()

    }



    override fun onPause() {
        super.onPause()
        Log.d(TAG,"MainActivity - onPause() called")
        brand_name.visibility = View.INVISIBLE

    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"MainActivity - onStop() called")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"MainActivity - onDestroy() called")
    }





    fun whenBrandLogoImageClicked() {
        btn_logo.setOnClickListener {
            val intent_When_Logo_Btn_Clicked_Activity = Intent(this,When_Logo_Btn_Clicked_Activity::class.java)
            if(isLiked == true) {
                startActivity(intent_When_Logo_Btn_Clicked_Activity)
                Log.d(TAG,"MainActivity - whenBrandLogoImageClicked() - startActivity(intent_When_Logo_Btn_Clicked_Activity) called")

            }else{
                Log.d(TAG,"MainActivity - whenBrandLogoImageClicked() Locked")
            }
        }
    }








}