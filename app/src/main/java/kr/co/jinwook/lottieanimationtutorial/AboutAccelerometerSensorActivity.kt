package kr.co.jinwook.lottieanimationtutorial

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import kotlinx.android.synthetic.main.activity_about_accelerometer_sensor.*
import kotlin.math.sqrt
import kotlinx.android.synthetic.main.activity_about_accelerometer_sensor.view.*



class AboutAccelerometerSensorActivity : AppCompatActivity(), SensorEventListener {

    val TAG : String = "로그"

    //센서메니저의 속성을 띈 변수 생성
    private lateinit var sensorManager: SensorManager
    //센서 감지를 위한 좌표계산 기준점
    private var sensorAccel : Float = 0.0f
    private var sensorAccelCurrent : Float = 0.0f
    private var sensorAccelLast : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG,"AboutAccelerometerSensorActivity - onCreate() called")

        setContentView(R.layout.activity_about_accelerometer_sensor)

        UIFunction.makeStatusBarTransparent(window)

        this.sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        sensorAccel = 10f
        sensorAccelCurrent = SensorManager.GRAVITY_EARTH //지구의 중력값 적용
        sensorAccelLast = SensorManager.GRAVITY_EARTH


    }

    override fun onStart() {
        super.onStart()

        Log.d(TAG,"AboutAccelerometerSensorActivity - onStart() called")
    }

    override fun onResume() {
        // 센서의 리스너 설정, 메인엑티비티 클래스에 센서이벤트리스너를 달았기 때문에 리스너부분에 this입력
        // getDefaultSensor로 사용자가 센서를 지정하지 않고 시스템에서 주는 센서에 접근,
        // 이 때 센서의 타입은 엑셀로미터(가속도계계
        // 센서가 감지하는 딜레이를 일반적인 값으로 설정
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)

        super.onResume()  //엑티비티에서 가지고 있는 onResume을 실행한다.

        Log.d(TAG,"AboutAccelerometerSensorActivity - onResume() called")

    }

    override fun onPause() {
        super.onPause()
        //센서리스너를 해제하고 onPause함수 실행되도록 순서 배정
        // pause상태에서는 센서 취소해줌
        sensorManager.unregisterListener(this)

        super.onPause()

        Log.d(TAG,"AboutAccelerometerSensorActivity - onPause() called")

    }

    override fun onStop() {
        super.onStop()

        Log.d(TAG,"AboutAccelerometerSensorActivity - onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d(TAG,"AboutAccelerometerSensorActivity - onDestroy() called")
    }

    override fun onSensorChanged(event: SensorEvent?) {
        //센서체인지드에서 어떻게 값이 변하게 될지 설정

        val x_Axis :Float = event?.values?.get(0) as Float
        val y_Axis :Float = event?.values?.get(1) as Float
        val z_Axis :Float = event?.values?.get(2) as Float

        x_axis_text.text = "X : " + x_Axis.toInt()
        y_axis_text.text = "Y : " + y_Axis.toInt()
        z_axis_text.text = "Z : " + z_Axis.toInt()

        sensorAccelLast = sensorAccelCurrent
        sensorAccelCurrent = sqrt((x_Axis*x_Axis + y_Axis*y_Axis + z_Axis*z_Axis).toDouble().toFloat())

        val delta : Float = sensorAccelCurrent - sensorAccelLast

        sensorAccel = sensorAccel *0.9f + delta



        if(sensorAccel > 30){
            Log.d(TAG,"AboutAccelerometerSensorActivity - 흔들었음")
            Log.d(TAG,"AboutAccelerometerSensorActivity - SensorAccel : ${sensorAccel}")

            face_image.setImageResource(R.drawable.laughing2)





            Handler().postDelayed({
                face_image.setImageResource(R.drawable.laughing)
            },1000)
        }

    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        Log.d(TAG,"MainActivity - onAccuracyChanged() called")
    }





}