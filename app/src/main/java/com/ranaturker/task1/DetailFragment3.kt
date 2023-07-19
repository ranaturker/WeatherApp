package com.ranaturker.task1

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ranaturker.task1.databinding.FragmentDetail3Binding
import viewBinding

class DetailFragment3 : Fragment(R.layout.fragment_detail3) {
    private val binding by viewBinding(FragmentDetail3Binding::bind)
    private var weatherData: WeatherData? = null
    private var randomTemperature: Int? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments.let {
            weatherData = it?.let {
                DetailFragment3Args.fromBundle(it).weatherData


            }
            binding.city.text = weatherData?.city
            binding.degree.text = weatherData?.degree
            binding.weatherSituation.text = weatherData?.weatherCondition
            when (weatherData?.weatherCondition) {
                getString(R.string.sunny) -> binding.weatherSituationImage.setImageResource(R.drawable.ic_sunny_2)
                "Bulutlu" -> binding.weatherSituationImage.setImageResource(R.drawable.ic_cloudy_2)
                "Yağmurlu" -> binding.weatherSituationImage.setImageResource(R.drawable.ic_rainy_2)
                "Karlı" -> binding.weatherSituationImage.setImageResource(R.drawable.ic_snowy_2)
            }

            binding.refresh.setOnClickListener {
                updateTemperature()

            }
            binding.button.setOnClickListener {
                sendData()
            }
        }
    }

    private fun generateRandomTemperature(min: Int, max: Int): Int {
        return min.rangeTo(max).random()
    }

    private fun updateTemperature() {
        val minTemperature = weatherData?.degreeGap?.split("° - ")?.first()?.toInt()
        val maxTemperature =
            weatherData?.degreeGap?.split("° - ")?.last()?.split("°")?.first()?.toInt()
        if (minTemperature != null && maxTemperature != null) {
            randomTemperature = generateRandomTemperature(minTemperature, maxTemperature)
        }
        binding.degree.text = randomTemperature.toString() + "°"
        weatherData?.degree = randomTemperature.toString() + "°"

    }

    private fun sendData() {
        if (randomTemperature != null) {
            val bundle = Bundle()
            bundle.putParcelable("degree", weatherData)
            // Fragment Result API'yi kullanarak verileri güncelle ve son random sıcaklık değerini geri gönder
            parentFragmentManager.setFragmentResult(
                "degreeKey",
                bundle
            )
        } else {
            Toast.makeText(requireContext(), "Verileriniz Güncellenemedi", Toast.LENGTH_LONG)
                .show()
        }
    }
}


