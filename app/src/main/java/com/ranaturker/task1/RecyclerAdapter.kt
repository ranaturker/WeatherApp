package com.ranaturker.task1
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context) .inflate (R. layout.recycler_view_row, parent, false)
        return ViewHolder (v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var itemImage: ImageView
        private var itemDegree: TextView
        private var itemCity: TextView
        private var itemDegreeGap: TextView
        private var itemWeatherSituation: TextView

        init {
            itemImage = itemView.findViewById(R.id.weather_situation_image)
            itemDegree = itemView.findViewById(R.id.degree)
            itemCity = itemView.findViewById(R.id.city)
            itemDegreeGap = itemView.findViewById(R.id.degree_gap)
            itemWeatherSituation = itemView.findViewById(R.id.weather_situation)
        }
    }
}