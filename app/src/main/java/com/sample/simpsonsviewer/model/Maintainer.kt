package com.sample.simpsonsviewer.model

import com.google.gson.annotations.SerializedName


data class Maintainer (

  @SerializedName("github" ) var github : String? = null

)