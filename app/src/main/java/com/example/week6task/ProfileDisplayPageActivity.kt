package com.example.week6task

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile_display_page.*

class ProfileDisplayPageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_display_page)

        /** Retrieving and setting extras from the Intent */
        val name = intent.getStringExtra("NAME")
        val eMail = intent.getStringExtra("EMAIL")
        val phoneNumber = intent.getStringExtra("PHONE_NO")
        val sex = intent.getStringExtra("SEX")

        /**Setting the values into the text view fields */
        tvName.text = name
        tvEmail.text = eMail
        tvPhoneNumber.text = phoneNumber
        tvSex.text = sex
    }

}