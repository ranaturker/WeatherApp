package com.ranaturker.task1.task2

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ranaturker.task1.R
import com.ranaturker.task1.RecyclerAdapter
import com.ranaturker.task1.WeatherData
import com.ranaturker.task1.databinding.FragmentListBinding
import viewBinding

class ListFragment : Fragment(R.layout.fragment_list), RecyclerAdapter.RecyclerViewEvent {
    private val binding by viewBinding(FragmentListBinding::bind)
    private lateinit var cityDataList: ArrayList<WeatherData>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityDataList = ArrayList()

        val istanbul = WeatherData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = WeatherData("Ankara", "25°", "18° - 30°", "Rüzgarlı")
        val erzurum = WeatherData("Erzurum", "24°", "26° - 42°", "Yağmurlu")
        val sakarya = WeatherData("Sakarya", "23°", "10° - 17°", "Karlı")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)

        val customAdapter = RecyclerAdapter(cityDataList, this)

        binding.recyclerView.adapter = customAdapter
    }

    override fun onItemClick(data: WeatherData) {
      /*  val bundle = Bundle()
        bundle.putParcelable("WeatherData", data)
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        parentFragmentManager.beginTransaction().add(R.id.container, detailFragment).commit()*/
    }
}

