package ng.com.jedun.biakadiet.util

import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import ng.com.jedun.biakadiet.R

fun Fragment.customNavAnimation(): NavOptions.Builder {

    val navBuilder: NavOptions.Builder = NavOptions.Builder()
    navBuilder.setEnterAnim(R.anim.slide_in_right).setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(R.anim.slide_in_left).setPopExitAnim(R.anim.slide_out_right)

    return navBuilder
}