package com.example.demo.ui.demo

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.example.demo.R
import com.example.demo.databinding.ActivityPlanTripBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class PlanATripActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityPlanTripBinding
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanTripBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.selectCountry.setOnClickListener {
            val intent = Intent(this, SelectCityActivity::class.java)
            startActivityForResult(intent,1)

        }

        binding.startDate.setOnClickListener {
            val intent = Intent(this, SelectCalendarActivity::class.java)
            startActivityForResult(intent,2)
        }

        binding.startDate.setOnClickListener {
            val intent = Intent(this, SelectCalendarActivity::class.java)
            startActivityForResult(intent,3)
        }

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnCreate.setOnClickListener {
            val bottomSheetDialog = BottomSheetDialog(this)
            val bottomSheetView: View = LayoutInflater.from(this).inflate(R.layout.create_trip_bottom, null)
            bottomSheetDialog.setContentView(bottomSheetView)


            // Button in BottomSheetDialog
            //val buttonClose = bottomSheetView.findViewById<Button>(R.id.buttonClose)
            //buttonClose.setOnClickListener { bottomSheetDialog.dismiss() }

            bottomSheetDialog.setOnShowListener { dialogInterface ->
                val bottomSheetDialog = dialogInterface as BottomSheetDialog
                val bottomSheet = bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet) as FrameLayout?

                bottomSheet?.let { sheet ->
                    val behavior = BottomSheetBehavior.from(sheet)
                    sheet.background = ContextCompat.getDrawable(this, R.drawable.rounded_bottom_sheet)
                    behavior.state = BottomSheetBehavior.STATE_EXPANDED
                    behavior.peekHeight = 0
                }

                val crossBtn = bottomSheet!!.findViewById<ImageView>(R.id.btnBack)

                crossBtn.setOnClickListener {
                    bottomSheetDialog.dismiss()
                    }

                val btnContinue = bottomSheet!!.findViewById<AppCompatButton>(R.id.btnContinue)

                btnContinue.setOnClickListener {
                    val intent = Intent(this, PlanTripDetailsActivity::class.java)
                    startActivity(intent)
                }

            }

            bottomSheetDialog.show()
        }


    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 1)
        {
            if (data != null) {
                binding.tvCountry.text = data.getStringExtra("result")
            }
        }
    }
}