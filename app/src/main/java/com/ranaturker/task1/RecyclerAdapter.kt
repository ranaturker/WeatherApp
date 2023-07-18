package com.ranaturker.task1

import android.provider.Settings.Global.getString
import androidx.recyclerview.widget.RecyclerView
import com.ranaturker.task1.databinding.RecyclerViewRowBinding
import android.view.LayoutInflater
import android.view.ViewGroup

class RecyclerAdapter(
    private val cityDataList: ArrayList<WeatherData>,
    val listener: RecyclerViewEvent
) :
    RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: RecyclerViewRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(cityDataList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RecyclerViewRowBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.binding) {
            city.text = cityDataList[position].city
            degree.text = cityDataList[position].degree
            weatherSituation.text = cityDataList[position].weatherCondition
            degreeGap.text = cityDataList[position].degreeGap
            when (cityDataList[position]?.weatherCondition) {
                "Güneşli"-> weatherSituationImage.setImageResource(R.drawable.ic_sunny_2)
                "Bulutlu" -> weatherSituationImage.setImageResource(R.drawable.ic_cloudy_2)
                "Yağmurlu" -> weatherSituationImage.setImageResource(R.drawable.ic_rainy_2)
                "Karlı" -> weatherSituationImage.setImageResource(R.drawable.ic_snowy_2)
            }
        }
    }
    override fun getItemCount(): Int {
        return cityDataList.size
    }

    interface RecyclerViewEvent {
        fun onItemClick(data: WeatherData)
    }
}
