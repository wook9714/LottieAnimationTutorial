package kr.co.jinwook.lottieanimationtutorial

import UIFunction
import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_when_logo_btn_clicked.*

class When_Logo_Btn_Clicked_Activity : AppCompatActivity() {

    val TAG : String = "로그"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_when_logo_btn_clicked)

        UIFunction.makeStatusBarTransparent(window)


    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"When_Logo_Btn_Clicked_Activity - onStart() called")
    }

    override fun onResume() {
        super.onResume()  //엑티비티에서 가지고 있는 onResume을 실행한다.

        whenAccelerometerSensorBtnClicked()
        whenXmlTestBtnClicked()
        whenFragmentBtnClicked()
        whenSliderImageClicked()

        Log.d(TAG,"When_Logo_Btn_Clicked_Activity - onResume() called")

    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"When_Logo_Btn_Clicked_Activity - onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"When_Logo_Btn_Clicked_Activity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"When_Logo_Btn_Clicked_Activity - onDestroy() called")
    }



    fun whenAccelerometerSensorBtnClicked() {
        btn_to_accelerometer_sensor.setOnClickListener {
            Log.d(TAG,"btn_to_accelerometer_sensor clicked")
            val intent_About_ACCelerometer_Sensor_Activity = Intent(this, AboutAccelerometerSensorActivity::class.java)
            startActivity(intent_About_ACCelerometer_Sensor_Activity)
        }
    }

    fun whenXmlTestBtnClicked() {
        btn_test_xml.setOnClickListener {
            Log.d(TAG,"When_Logo_Btn_Clicked_Activity - whenXmlTestBtnClicked() called")
            val intent_test_xml_for_HaveASeat_activity = Intent(this, test_xml_for_HaveASeat_activity::class.java)
            startActivity(intent_test_xml_for_HaveASeat_activity)
        }
    }

    fun whenFragmentBtnClicked() {
        btn_fragment.setOnClickListener {
            Log.d(TAG,"btn_fragment clicked")
            val intent_About_Fragment = Intent(this, About_Fragment_activity::class.java)
            startActivity(intent_About_Fragment)
        }
    }

    fun whenSliderImageClicked(){
        btn_SliderImage.setOnClickListener {
            Log.d(TAG,"btn_SliderImage clicked")
            val intent_Slider_Image = Intent(this, SliderImageViewActivity::class.java)
            startActivity(intent_Slider_Image)
        }
    }





}

