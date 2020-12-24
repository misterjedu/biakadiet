package ng.com.jedun.dietify.ui

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import ng.com.jedun.dietify.R

abstract class BaseActivity : AppCompatActivity() {

    lateinit var progressBar: ProgressBar

    override fun setContentView(layoutResID: Int) {

        val constraintLayout: ConstraintLayout =
            layoutInflater.inflate(R.layout.activity_base, null) as ConstraintLayout

        val frameLayout: FrameLayout =
            constraintLayout.findViewById(R.id.activity_base_container_fl)

        progressBar = constraintLayout.findViewById(R.id.activity_base_progress_bar)

        layoutInflater.inflate(layoutResID, frameLayout, true)

        super.setContentView(layoutResID)
    }

    fun showProgressBar(visibility: Boolean) {
        progressBar.visibility = if (visibility) View.VISIBLE else View.GONE
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
    }
}