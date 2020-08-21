package com.studytrial.ccstorage


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.activity_splash_screen.*


class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        this.supportActionBar?.hide()
        val sharedPreferences = getSharedPreferences(Login.FIELD_USERNAME, Context.MODE_PRIVATE)
        val nameSplash = sharedPreferences.getString(Login.FIELD_USERNAME, null)

        Handler(Looper.getMainLooper()).postDelayed({
            val contains = sharedPreferences.contains(Login.FIELD_LOGIN)
            if (contains){
                tv_splash.setText(nameSplash)
            }
            startActivity(Intent(this, LandingPage::class.java))
            finish()
        }, 3000)
    }
}