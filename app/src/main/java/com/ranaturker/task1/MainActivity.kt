package com.ranaturker.task1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ranaturker.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), RecyclerAdapter.RecyclerViewEvent {
    private lateinit var cityDataList : ArrayList<WeatherData>
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        cityDataList = ArrayList()

        val istanbul = WeatherData("İstanbul", "26°", "14° - 27°", "Güneşli")
        val ankara = WeatherData("Ankara", "26°", "14° - 27°", "Güneşli")
        val erzurum = WeatherData("Erzurum", "26°", "14° - 27°", "Güneşli")
        val sakarya = WeatherData("Sakarya", "26°", "14° - 27°", "Güneşli")

        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)
        cityDataList.add(istanbul)
        cityDataList.add(ankara)
        cityDataList.add(erzurum)
        cityDataList.add(sakarya)


        val customAdapter = RecyclerAdapter(cityDataList , this)
        binding.mRecyclerView.adapter = customAdapter


    }

    override fun onItemClick(data: WeatherData) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("data",WeatherData::class.java)

        startActivity(intent)
    }
}
