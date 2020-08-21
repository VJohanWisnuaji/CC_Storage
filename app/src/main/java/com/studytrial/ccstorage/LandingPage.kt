package com.studytrial.ccstorage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_landing_page.*
import kotlinx.coroutines.currentCoroutineContext

class LandingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        this.supportActionBar?.hide()
        vp_landing.adapter = LandingAdapter(supportFragmentManager)
        tabDots.setupWithViewPager(vp_landing, true)
    }
}
