package com.example.submission1_dicoding

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class SplaceScreen : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace_screen2)

        val timerThread: Thread = object : Thread() {
            override fun run() {
                try {
                    sleep(3000)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                } finally {
                    val intent = Intent(this@SplaceScreen, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
        timerThread.start()

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

}