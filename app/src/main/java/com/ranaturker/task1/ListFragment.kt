package com.ranaturker.task1

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.hercan.weatherapp2.presentation.viewbinding.viewBinding
import com.ranaturker.task1.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list), RecyclerAdapter.RecyclerViewEvent {
    private val binding by viewBinding(FragmentListBinding::bind)
    private lateinit var cityDataList: ArrayList<WeatherData>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cityDataList = ArrayList()

        val istanbul = WeatherData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = WeatherData("Ankara", "25°", "18° - 30°", "Güneşli")
        val erzurum = WeatherData("Erzurum", "24°", "26° - 42°", "Güneşli")
        val sakarya = WeatherData("Sakarya", "23°", "10° - 17°", "Güneşli")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)

        val customAdapter = RecyclerAdapter(cityDataList, this)

        binding.recyclerView.adapter = customAdapter

    }

    override fun onItemClick(data: WeatherData) {
        val bundle = Bundle()
        bundle.putParcelable("WeatherData", data)
        val detailFragment = DetailFragment()
        detailFragment.arguments = bundle
        parentFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.fragment, detailFragment)
            addToBackStack("detailFragment")
        }
    }
}

