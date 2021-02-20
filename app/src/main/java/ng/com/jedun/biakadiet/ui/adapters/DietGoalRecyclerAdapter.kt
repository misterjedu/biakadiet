package ng.com.jedun.biakadiet.ui.adapters

import android.util.SparseBooleanArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ng.com.jedun.biakadiet.R
import ng.com.jedun.biakadiet.databinding.DietGoalItemsBinding
import ng.com.jedun.biakadiet.models.DietGoal
import ng.com.jedun.biakadiet.ui.adapters.DietGoalRecyclerAdapter.DietGoalViewHolder
import ng.com.jedun.biakadiet.util.Callback

class DietGoalRecyclerAdapter : RecyclerView.Adapter<DietGoalViewHolder>() {

    private var dietGoals = mutableListOf<DietGoal>()

    private var clickListener: Callback<DietGoal>? = null

    var checkBoxStateArray = SparseBooleanArray()


    override fun getItemCount() = dietGoals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DietGoalViewHolder {
        return DietGoalViewHolder(
            DietGoalItemsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: DietGoalViewHolder, position: Int) {

        holder.binding.dietGoalCheckbox.isChecked = checkBoxStateArray.get(position, false)

        val currentGoal = dietGoals[position]
        val checkBox = holder.binding.dietGoalCheckbox
        val dietGoalCard = holder.binding.dietGoalCard
        val dietGoalTextView = holder.binding.dietGoalTv

        holder.itemView.apply {
            holder.binding.dietGoalTv.text = currentGoal.goal

            setOnClickListener {
                clickListener?.let {

                    //Since recycler view recycles it's views, selected items begin to appear duplicated as you
                    // go further down or up the list. The sparse boolean array solves this problem.
                    if (!checkBoxStateArray.get(position, false)) {

                        checkBox.isChecked = true

//                        dietGoalCard.setBackgroundColor(
//                            ContextCompat.getColor(context, R.color.color_primary)
//                        )
//
//                        dietGoalTextView.setTextColor(
//                            ContextCompat.getColor(context, R.color.white)
//                        )

                        checkBoxStateArray.put(position, true)

                    } else {
                        checkBox.isChecked = false

//                        dietGoalCard.setBackgroundColor(
//                            ContextCompat.getColor(context, R.color.white)
//                        )
//
//                        dietGoalTextView.setTextColor(
//                            ContextCompat.getColor(context, R.color.black)
//                        )
                        checkBoxStateArray.put(position, false)
                    }

                    it(currentGoal)
                }
            }
        }
    }


    fun setClickListener(clickListener: Callback<DietGoal>) {
        this.clickListener = clickListener
    }

    fun setDietGoalList(goals: List<DietGoal>) {
        this.dietGoals = goals as MutableList<DietGoal>
    }


    inner class DietGoalViewHolder(val binding: DietGoalItemsBinding) :
        RecyclerView.ViewHolder(binding.root)

}
