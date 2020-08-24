package com.studytrial.ccstorage

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private var usernameInSP: String? = "Username"
    private var passwordInSP: String? = "Password"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.supportActionBar?.hide()
        val sharedPreferences = getSharedPreferences(Login.FIELD_USERNAME, Context.MODE_PRIVATE)
        val isLogin = sharedPreferences.getBoolean(Login.FIELD_LOGIN, false)
        usernameInSP = sharedPreferences.getString(Login.FIELD_USERNAME, "sabrina")
        passwordInSP = sharedPreferences.getString(Login.FIELD_PASSWORD, "binar123")

        if (isLogin) {
            et_login_username.setText(usernameInSP)
            et_login_password.setText(passwordInSP)
        }

        btn_login.setOnClickListener {
            val username = et_login_username.text.toString()
            val password = et_login_password.text.toString()

            if (username == usernameInSP && password == passwordInSP) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                val editor = sharedPreferences.edit()
                editor.putBoolean(Login.FIELD_LOGIN, true)
                editor.apply()
            } else if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username atau Password wajib diisi", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }

        btn_reset.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString(Login.FIELD_USERNAME, "sabrina")
            editor.putString(Login.FIELD_PASSWORD, "binar123")
            editor.putBoolean(Login.FIELD_LOGIN, false)
            editor.apply()
            et_login_username.text = null
            et_login_password.text = null
            recreate()
        }
    }
}