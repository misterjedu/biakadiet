package ng.com.jedun.biakadiet.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ng.com.jedun.biakadiet.databinding.DietGoalItemsBinding
import ng.com.jedun.biakadiet.models.DietGoal
import ng.com.jedun.biakadiet.ui.adapters.DietGoalRecyclerAdapter.DietGoalViewHolder
import ng.com.jedun.biakadiet.util.Callback

class DietGoalRecyclerAdapter : RecyclerView.Adapter<DietGoalViewHolder>() {

    private var dietGoals = mutableListOf<DietGoal>()

    private var clickListener: Callback<DietGoal>? = null

    inner class DietGoalViewHolder(val binding: DietGoalItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun getItemCount() = dietGoals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietGoalViewHolder {
        return DietGoalViewHolder(
            DietGoalItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DietGoalViewHolder, position: Int) {

        val currentGoal = dietGoals[position]

        holder.itemView.apply {
            holder.binding.dietGoalTv.text = currentGoal.goal
            setOnClickListener {
                clickListener?.let { it(currentGoal) }
            }
        }
    }


    fun setClickListener(clickListener: Callback<DietGoal>) {
        this.clickListener = clickListener
    }

    fun setDietGoalList(goals: List<DietGoal>) {
        this.dietGoals = goals as MutableList<DietGoal>
    }

}
