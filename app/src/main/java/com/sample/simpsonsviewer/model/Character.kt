package com.sample.simpsonsviewer.model

import com.google.gson.annotations.SerializedName

data class Character (
    @SerializedName("FirstURL" ) var FirstURL : String? = null,
    @SerializedName("Icon"     ) var Icon     : Icon?   = Icon(),
    @SerializedName("Result"   ) var Result   : String? = null,
    @SerializedName("Text"     ) var Text     : String? = null,
    var description: String
)