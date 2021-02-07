package ng.com.jedun.biakadiet.ui.auth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ng.com.jedun.biakadiet.R

class AuthViewPagerAdapter(data: Pair<List<Int>, List<String>>) :
    RecyclerView.Adapter<AuthViewPagerAdapter.ViewPagerViewHolder>() {

    private val images = data.first
    private val description = data.second

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.auth_item_view_pager, parent, false)
        return ViewPagerViewHolder(view)
    }

    override fun getItemCount(): Int {
        return images.size
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val currentImage = images[position]
        val currentDescription = description[position]
        holder.itemView.findViewById<ImageView>(R.id.onboarding_image)
            .setImageResource(currentImage)
        holder.itemView.findViewById<TextView>(R.id.onboarding_text).text = currentDescription
    }

    inner class ViewPagerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}