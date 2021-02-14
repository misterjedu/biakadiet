package ng.com.jedun.biakadiet.util

import androidx.fragment.app.Fragment
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.models.DietGoal

object DataCenter {

    fun onBoardingDescriptions(fragment: Fragment): List<String> {
        return listOf(
            fragment.resources.getString(R.string.decision_on_what_you_eat),
            fragment.resources.getString(R.string.decision_on_what_you_eat),
            fragment.resources.getString(R.string.decision_on_what_you_eat)
        )
    }

    fun onBoardingImages(): List<Int> {
        return listOf(
            R.drawable.onboarding_image_one,
            R.drawable.onboarding_image_two,
            R.drawable.onboarding_image_three
        )

    }

    @JvmStatic
    fun dietGoals(): List<DietGoal> {
        return mutableListOf(
            DietGoal("Weight Loss"),
            DietGoal("Weight Gain"),
            DietGoal("Muscle Gain"),
            DietGoal("Abs Gain")
        )
    }
}