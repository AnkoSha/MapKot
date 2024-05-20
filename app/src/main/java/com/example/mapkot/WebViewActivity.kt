package com.example.mapkot

import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mapkot.R

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        val webView: WebView = findViewById(R.id.webView)
        val url: String? = intent.getStringExtra("url")

        if (url != null) {
            webView.settings.javaScriptEnabled = true
            webView.loadUrl(url)
        } else {
            Toast.makeText(this, "URL не найден", Toast.LENGTH_SHORT).show()
        }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this, QuizActivity2::class.java)
            startActivity(intent)
        }
    }

}