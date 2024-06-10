package com.example.weatherapp


//Name: Taahir Hoosen
// Student Number: ST10445196
//Reference for logo: Rachmat Budiaji..Icon set cloud weather. Realistic symbol design[Online].Available at: https://www.vecteezy.com/vector-art/15601190-icon-set-cloud-weather-realistic-symbol-design-complete-collection-isolated-on-white-background-vector-illustration



import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var averageTemperatureTextView: TextView
    private var temperatures = arrayListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        averageTemperatureTextView = findViewById(R.id.AverageTemp)
        val viewDetailsButton: Button = findViewById(R.id.btnViewDetails)
        val calculateAverageButton: Button = findViewById(R.id.btnCalculateAverage)
        val clearDataButton: Button = findViewById(R.id.btnClearData)
        val exitButton: Button = findViewById(R.id.btnExit)

        viewDetailsButton.setOnClickListener {
            val intent = Intent(this, DetailedViewActivity::class.java)
            startActivityForResult(intent, 1)
        }

        calculateAverageButton.setOnClickListener {
            if (temperatures.isNotEmpty()) {
                val average = temperatures.average()
                averageTemperatureTextView.text = "Average Temperature: %.2f".format(average)
            }
        }

        clearDataButton.setOnClickListener {
            temperatures.clear()
            averageTemperatureTextView.text = "Average Temperature: "
        }

        exitButton.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            data?.let {
                temperatures = it.getIntegerArrayListExtra("TEMPERATURES") ?: arrayListOf()
            }
        }
    }
}