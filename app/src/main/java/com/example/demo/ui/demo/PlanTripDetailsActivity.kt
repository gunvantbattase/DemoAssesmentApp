package com.example.demo.ui.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.PlanTripActivityBinding

class PlanTripDetailsActivity : AppCompatActivity()
{
    private lateinit var binding: PlanTripActivityBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = PlanTripActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.textView6.setOnClickListener {
            finish()
        }
    }
}