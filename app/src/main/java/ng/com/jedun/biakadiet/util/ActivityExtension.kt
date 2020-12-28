package ng.com.jedun.biakadiet.util

import android.app.Activity
import android.widget.Toast


fun Activity.makeToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}