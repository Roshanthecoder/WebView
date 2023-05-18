package com.example.webview

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.webkit.WebView

class CustomWebView : WebView {

    private var startScrollY = 0f

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> startScrollY = event.y
            MotionEvent.ACTION_MOVE -> {
                val deltaY = event.y - startScrollY
                scrollBy(0, -deltaY.toInt())
                startScrollY = event.y
            }
        }
        return super.onTouchEvent(event)
    }
}
