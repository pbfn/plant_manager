package com.pedrobruno.plant_manager.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pedrobruno.plant_manager.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val splashScreenTimeOut = 2000L
        val homeIntent = Intent(this@SplashActivity, MainActivity::class.java)
        Handler().postDelayed({
            startActivity(homeIntent)
            finish()
        }, splashScreenTimeOut)
    }
}