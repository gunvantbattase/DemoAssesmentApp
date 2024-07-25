package com.example.demo.ui.demo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.example.DataObjects
import com.example.demo.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DemoRepository(application: Application) {
    //private var application: Application? = null



    private val dataObjects: DataObjects = DataObjects()
    private val dataObjectsMutableList: MutableLiveData<List<DataObjects>> = MutableLiveData<List<DataObjects>>()


    //get Objects
    fun getObjects(): MutableLiveData<List<DataObjects>>
    {
        try {
            val call: Call<List<DataObjects>> = RetrofitClient.instance.demoObjects()

            call.enqueue(object : Callback<List<DataObjects>> {
                override fun onResponse(
                    call: Call<List<DataObjects>>,
                    response: Response<List<DataObjects>>
                ) {
                    //Log.i("data", Gson().toJson(response.body()))
                    dataObjectsMutableList.value = response.body()

                    try {

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                override fun onFailure(call: Call<List<DataObjects>>, t: Throwable) {
                    //dataObjectsMutableList.value = ""

                    t.printStackTrace()
                }


            })
        } catch (e: Exception) {
            //dataObjectsMutableList.value = null

            e.printStackTrace()
        }
        return dataObjectsMutableList
    }

}