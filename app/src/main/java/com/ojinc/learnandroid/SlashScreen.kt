package com.ojinc.learnandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SlashScreen : AppCompatActivity() {

    private val screenTime : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_slash_screen)

        Handler().postDelayed({
            startActivity(Intent (this, MainActivity::class.java))
            finish()
        }, screenTime)
    }
}