package com.ranaturker.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ranaturker.task1.databinding.ActivityDetailsBinding


class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val data = intent.parcelable<WeatherData>("data")

        binding.city.text = data?.city
        binding.degree.text = data?.degree
    }
}
