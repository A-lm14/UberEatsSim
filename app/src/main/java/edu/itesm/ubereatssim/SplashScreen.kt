package edu.itesm.ubereatssim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.view.WindowManager
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        message(4)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)
    }

    private fun message(time:Int){
        object : CountDownTimer(((time * 1000).toLong()), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timer.visibility = View.VISIBLE
                val timerText = millisUntilFinished / 1000;
                timer.text = timerText.toString()
            }
            override fun onFinish() {
                timer.visibility = View.INVISIBLE
                timer.text = ""
            }
        }.start()
    }
}