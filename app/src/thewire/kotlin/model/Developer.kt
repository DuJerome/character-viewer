package com.sample.thewire.model

import com.google.gson.annotations.SerializedName


data class Developer (
  @SerializedName("name" ) var name : String? = null,
  @SerializedName("type" ) var type : String? = null,
  @SerializedName("url"  ) var url  : String? = null
)