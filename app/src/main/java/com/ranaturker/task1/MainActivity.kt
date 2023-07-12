package com.ranaturker.task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.ranaturker.task1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setClickListeners()
    }

    private fun setClickListeners() {
        with(binding) {
            city.setOnClickListener {
                Toast.makeText(this@MainActivity, city.text, Toast.LENGTH_SHORT).show()
            }

            degree.setOnClickListener {
                Toast.makeText(this@MainActivity, degree.text, Toast.LENGTH_SHORT).show()

            }
        }
    }
}