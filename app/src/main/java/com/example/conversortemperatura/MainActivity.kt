package com.example.conversortemperatura

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val celsiusInput = findViewById<EditText>(R.id.celsiusInput)
        val convertButton = findViewById<Button>(R.id.convertButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        convertButton.setOnClickListener {
            val celsius = celsiusInput.text.toString().trim().replace(',', '.').toDoubleOrNull()

            if (celsius == null) {
                celsiusInput.error = getString(R.string.temperature_required)
                resultText.text = ""
                return@setOnClickListener
            }

            celsiusInput.error = null
            val fahrenheit = (celsius * 9 / 5) + 32
            resultText.text = getString(
                R.string.conversion_result,
                String.format(Locale.getDefault(), "%.2f", celsius),
                String.format(Locale.getDefault(), "%.2f", fahrenheit)
            )
        }
    }
}
