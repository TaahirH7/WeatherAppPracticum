package com.example.weatherapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlin.system.exitProcess

//Name: Taahir Hoosen
// Student Number: ST10445196
//Reference for logo: Rachmat Budiaji..Icon set cloud weather. Realistic symbol design[Online].Available at: https://www.vecteezy.com/vector-art/15601190-icon-set-cloud-weather-realistic-symbol-design-complete-collection-isolated-on-white-background-vector-illustration


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val btnMainMenu: Button = findViewById(R.id.btnMainMenu)
        btnMainMenu.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }

        val btnExit: Button = findViewById(R.id.btnExit)
        btnExit.setOnClickListener {

            exitProcess(0)
        }
    }
}
