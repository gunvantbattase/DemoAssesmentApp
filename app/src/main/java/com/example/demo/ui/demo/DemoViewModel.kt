package com.example.demo.ui.demo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.example.DataObjects

class DemoViewModel(application: Application) : AndroidViewModel(application)
{
    private var demoRepository: DemoRepository? = null


    init {
        demoRepository = DemoRepository(application)
    }



    fun getDataObjects(): MutableLiveData<List<DataObjects>>? {
        return demoRepository?.getObjects()
    }
}