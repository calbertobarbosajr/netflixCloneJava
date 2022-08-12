package com.example.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
            AbrirTelaLogin()
        },2000)
    }

    private fun AbrirTelaLogin(){
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
        finish()
    }
}
