package ng.com.jedun.biakadiet.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ng.com.jedun.biakadiet.databinding.FragmentOnBoardingTwoBinding
import ng.com.jedun.biakadiet.ui.BaseFragment
import ng.com.jedun.biakadiet.ui.adapters.DietGoalRecyclerAdapter
import ng.com.jedun.biakadiet.util.DataCenter
import ng.com.jedun.biakadiet.util.toast

class OnBoardingTwo : BaseFragment() {

    private var _binding: FragmentOnBoardingTwoBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: DietGoalRecyclerAdapter

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
        adapter.setClickListener {
            toast(it.goal)
        }
        binding.goalsDietRecyclerView.adapter = adapter


    }


}