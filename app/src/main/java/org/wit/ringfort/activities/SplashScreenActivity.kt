package org.wit.ringfort.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
//import android.support.v7.app.AppCompatActivity
import androidx.appcompat.app.AppCompatActivity
import org.wit.ringfort.R

class SplashScreenActivity : AppCompatActivity() {
    private val SPLASH_TIME_OUT:Long=3000 // 3 sec
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler().postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity

            startActivity(Intent(this,LoginActivity::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}