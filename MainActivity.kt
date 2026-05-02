package com.example.phishguardlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {

    // URL history list
    val history = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.urlInput)
        val button = findViewById<Button>(R.id.checkBtn)
        val result = findViewById<TextView>(R.id.resultText)

        button.setOnClickListener {
            val url = input.text.toString()

            // Log checked URLs
            history.add(url)

            if (url.contains("login") || url.contains("verify") || url.contains("bit.ly")) {
                result.text = getString(R.string.phish_warning)
            } else {
                result.text = getString(R.string.safe_link)
            }
        }
    }
}
