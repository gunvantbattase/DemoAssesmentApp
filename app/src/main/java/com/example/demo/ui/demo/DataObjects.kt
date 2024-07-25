package com.example.example

import com.google.gson.annotations.SerializedName


data class DataObjects (

  @SerializedName("id"   ) var id   : String? = null,
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("data" ) var data : DemoData?   = DemoData()

)