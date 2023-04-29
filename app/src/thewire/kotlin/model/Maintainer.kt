package com.sample.thewire.model

import com.google.gson.annotations.SerializedName


data class Maintainer (

  @SerializedName("github" ) var github : String? = null

)