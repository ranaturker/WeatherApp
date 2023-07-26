package com.ranaturker.task1.task2

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.ranaturker.task1.R
import com.ranaturker.task1.WeatherData

class DetailFragment : Fragment() {
    var data: WeatherData? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            data = if (Build.VERSION.SDK_INT >= 33) {
                bundle.getParcelable("WeatherData", WeatherData::class.java)
            } else {
                bundle.getParcelable("WeatherData")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val cityTextView = view.findViewById<TextView>(R.id.city)
        cityTextView.text = data?.city
        val degreeView = view.findViewById<TextView>(R.id.degree)
        degreeView.text = data?.degree
        return view
    }
}
