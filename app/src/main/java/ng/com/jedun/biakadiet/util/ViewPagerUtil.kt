package ng.com.jedun.biakadiet.util

import androidx.viewpager2.widget.ViewPager2
import android.os.Handler
import android.os.Looper

fun ViewPager2.autoScroll(interval: Long) {

    val handler = Handler(Looper.myLooper()!!)
    var scrollPosition = 0

    val runnable = object : Runnable {

        override fun run() {
            val count = adapter?.itemCount ?: 0
            setCurrentItem(scrollPosition++ % count, true)

            handler.postDelayed(this, interval)
        }
    }

    registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {

        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            scrollPosition = position + 1
        }
    })

    handler.post(runnable)
}