package com.ranaturker.task1

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.FragmentResultListener
import androidx.navigation.fragment.findNavController
import com.ranaturker.task1.databinding.FragmentList3Binding
import viewBinding

class ListFragment3 : Fragment(R.layout.fragment_list3), RecyclerAdapter.RecyclerViewEvent {
    private val binding by viewBinding(FragmentList3Binding::bind)
    private lateinit var cityDataList: ArrayList<WeatherData>
    private var weatherData: WeatherData? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityDataList = ArrayList()

        val istanbul = WeatherData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = WeatherData("Ankara", "25°", "18° - 30°", "Rüzgarlı")
        val erzurum = WeatherData("Erzurum", "21°", "16° - 22°", "Yağmurlu")
        val sakarya = WeatherData("Sakarya", "5°", "0° - 7°", "Karlı")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)

        val customAdapter = RecyclerAdapter(cityDataList, this)

        binding.recyclerView.adapter = customAdapter

        parentFragmentManager.setFragmentResultListener("degreeKey", this,
            FragmentResultListener { requestKey, result ->
                weatherData = if (Build.VERSION.SDK_INT >= 33) {
                    result.getParcelable("degree", WeatherData::class.java)
                } else {
                    result.getParcelable("degree")
                }
                weatherData?.let {
                    var weatherIndex = 0
                    cityDataList.forEachIndexed { index, data ->
                        if (data.city == weatherData?.city) {
                            weatherIndex = index
                        }
                    }
                    cityDataList.set(weatherIndex, weatherData!!)


                }
            })

    }

    override fun onItemClick(data: WeatherData) {
        findNavController().navigate(
            ListFragment3Directions.actionListFragment3ToDetailFragment3(
                data
            )
        )
    }
}
