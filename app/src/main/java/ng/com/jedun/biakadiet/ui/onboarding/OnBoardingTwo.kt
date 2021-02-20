package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.keyIterator
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.FragmentOnBoardingTwoBinding
import ng.com.jedun.biakadiet.ui.BaseFragment
import ng.com.jedun.biakadiet.ui.adapters.DietGoalRecyclerAdapter
import ng.com.jedun.biakadiet.util.DataCenter
import ng.com.jedun.biakadiet.util.toast
import ng.com.jedun.biakadiet.widgets.FixedMaterialSpinner

class OnBoardingTwo : BaseFragment() {

    private var _binding: FragmentOnBoardingTwoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DietGoalRecyclerAdapter
    var selectedDietGoal = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOnBoardingTwoBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DietGoalRecyclerAdapter()
        adapter.setDietGoalList(DataCenter.dietGoals())

        val goalList =
            mutableListOf<String>(*resources.getStringArray(R.array.diet_goals))

        val dietGoalSpinner: FixedMaterialSpinner = binding.goalSpinner
        dietGoalSpinner.setItems(goalList)

        dietGoalSpinner.setOnItemSelectedListener { view, position, id, item ->
            selectedDietGoal = item as String
        }


        adapter.setClickListener { dietGoal ->
            val checkedListArr = mutableListOf<String>()
            adapter.checkBoxStateArray.keyIterator().forEach {
                if (adapter.checkBoxStateArray.get(it)) {
                    checkedListArr.add(DataCenter.dietGoals()[it].goal)
                }
            }

            println(checkedListArr.toList())
        }

        binding.goalsDietRecyclerView.adapter = adapter

    }


}