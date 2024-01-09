package org.freedu.noteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_2)
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(
                this@SplashScreenActivity,MainActivity::class.java
            ))
            finishAffinity()
        },3000)

        WindowInsetsControllerCompat(window,window.decorView).hide(WindowInsetsCompat.Type.statusBars())

    }
}