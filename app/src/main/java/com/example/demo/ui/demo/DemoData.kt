package com.example.example

import com.google.gson.annotations.SerializedName


data class DemoData (

  @SerializedName("color"    ) var color    : String? = null,
  @SerializedName("capacity" ) var capacity : String? = null

)