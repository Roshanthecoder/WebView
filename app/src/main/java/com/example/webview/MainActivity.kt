package com.example.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.view.View.OnTouchListener
import android.webkit.WebSettings
import androidx.appcompat.app.AppCompatActivity
import com.example.webview.databinding.ActivityMainBinding


lateinit var binding: ActivityMainBinding
lateinit var url: String

class MainActivity : AppCompatActivity() {
    @SuppressLint("JavascriptInterface")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        url = "https://rebliss.in/"
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.setLayerType(View.LAYER_TYPE_HARDWARE, null)
        binding.webView.loadUrl(url)
        binding.webView.settings.apply {

            cacheMode = WebSettings.LOAD_DEFAULT
            loadsImagesAutomatically = true
            setSupportZoom(false)
            setSupportMultipleWindows(false)
            domStorageEnabled = true
            javaScriptCanOpenWindowsAutomatically = false
        }
        binding.webView.setOnTouchListener(OnTouchListener { v, event ->
            v.parent.requestDisallowInterceptTouchEvent(true)
            false
        })


    }
    override fun onBackPressed() {
        if (binding.webView.canGoBack()) {
            binding.webView.goBack()
        } else {
            super.onBackPressed()
        }
    }
}



