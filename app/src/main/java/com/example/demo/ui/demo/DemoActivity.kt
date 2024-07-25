package com.example.demo.ui.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.demo.databinding.ActivityDemoBinding

class DemoActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDemoBinding
    private var demoViewModel: DemoViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        demoViewModel = ViewModelProvider(this).get(DemoViewModel::class.java)
        binding.button.setOnClickListener {
            demoViewModel!!.getDataObjects()?.observe(this) { response ->

                try {
                    if (response != null) {
                        //Toast.makeText(this,""+response,Toast.LENGTH_LONG).show()
                        binding.txtResult.setText(response.toString())
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        binding.buttonDesign.setOnClickListener {
            val intent = Intent(this, PlanATripActivity::class.java)
            startActivity(intent)
        }




    }
}