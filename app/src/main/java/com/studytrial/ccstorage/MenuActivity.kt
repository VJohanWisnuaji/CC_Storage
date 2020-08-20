package com.studytrial.ccstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val sharedPreferences = getSharedPreferences(Login.FIELD_USERNAME, Context.MODE_PRIVATE)
        val usernameInSP = sharedPreferences.getString(Login.FIELD_USERNAME, null)

        tv_vs_pemain.setText("$usernameInSP VS Pemain")
        tv_vs_komputer.setText("$usernameInSP VS CPU")

        iv_menu_komputer.setOnClickListener {
            startActivity(Intent(this, GameKomp::class.java))
        }
        iv_menu_pemain.setOnClickListener {
            startActivity(Intent(this, GamePemain::class.java))
        }
        iv_profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}