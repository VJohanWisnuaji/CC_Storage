package com.studytrial.ccstorage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class ProfileActivity : AppCompatActivity() {
    private lateinit var db: MemoDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        MemoDatabase.getInstance(this)?.let {
            db = it
        }

        val sharedPreferences = getSharedPreferences(Login.FIELD_USERNAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val usernameInSP = sharedPreferences.getString(Login.FIELD_USERNAME, null)
        val emailInSP = sharedPreferences.getString(Login.FIELD_EMAIL, null)

        et_profile_username.setText(usernameInSP)

        if (!emailInSP.isNullOrBlank()) {
            et_profile_email.setText(emailInSP)
        }

        et_profile_username.addTextChangedListener {
            editor.putString(Login.FIELD_USERNAME, et_profile_username.text.toString())
            editor.apply()
        }

        et_profile_email.addTextChangedListener {
            editor.putString(Login.FIELD_EMAIL, et_profile_email.text.toString())
            editor.apply()
        }

        iv_profile_back.setOnClickListener {
            finish()
        }

        fab_tambah_memo.setOnClickListener {
            AddMemoFragment.newInstance().show(supportFragmentManager, null)
        }
    }

    override fun onResume() {
        super.onResume()
        fetchData()
    }

    fun fetchData() {
        GlobalScope.launch {
            val listItem = db.memoDao().getMemo()

            runOnUiThread {
                val adapter = MemoAdapter(listItem)
                rv_profile.layoutManager =
                    LinearLayoutManager(this@ProfileActivity, LinearLayoutManager.VERTICAL, false)
                rv_profile.adapter = adapter
            }
        }
    }

    fun editMemo(date: String, memo: String, list: Memo){
        EditMemoFragment.newInstance(date, memo, list).show(supportFragmentManager, null)
    }
}