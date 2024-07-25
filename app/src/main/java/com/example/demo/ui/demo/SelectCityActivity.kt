package com.example.demo.ui.demo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.demo.databinding.SelectCountryBinding

class SelectCityActivity : AppCompatActivity()
{
    private lateinit var binding: SelectCountryBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = SelectCountryBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.imgClose.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

        binding.city1.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Laghouat Algeria");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

        binding.city2.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Lagos, Nigeria");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

        binding.city3.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Lagos, Nigeria");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

        binding.city4.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Doha, Qatar");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        binding.city5.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Doha, Qatar");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }
        binding.city6.setOnClickListener {
            val intent = Intent()
            intent.putExtra("result","Doha, Qatar");
            setResult(Activity.RESULT_OK,intent);
            finish();
        }

    }
}