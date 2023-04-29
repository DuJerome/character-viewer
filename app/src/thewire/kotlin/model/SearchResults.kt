package com.sample.thewire.model

import com.google.gson.annotations.SerializedName

data class SearchResults (
    @SerializedName("Abstract"         ) var Abstract         : String?                  = null,
    @SerializedName("AbstractSource"   ) var AbstractSource   : String?                  = null,
    @SerializedName("AbstractText"     ) var AbstractText     : String?                  = null,
    @SerializedName("AbstractURL"      ) var AbstractURL      : String?                  = null,
    @SerializedName("Answer"           ) var Answer           : String?                  = null,
    @SerializedName("AnswerType"       ) var AnswerType       : String?                  = null,
    @SerializedName("Definition"       ) var Definition       : String?                  = null,
    @SerializedName("DefinitionSource" ) var DefinitionSource : String?                  = null,
    @SerializedName("DefinitionURL"    ) var DefinitionURL    : String?                  = null,
    @SerializedName("Entity"           ) var Entity           : String?                  = null,
    @SerializedName("Heading"          ) var Heading          : String?                  = null,
    @SerializedName("Image"            ) var Image            : String?                  = null,
    @SerializedName("ImageHeight"      ) var ImageHeight      : Int?                     = null,
    @SerializedName("ImageIsLogo"      ) var ImageIsLogo      : Int?                     = null,
    @SerializedName("ImageWidth"       ) var ImageWidth       : Int?                     = null,
    @SerializedName("Infobox"          ) var Infobox          : String?                  = null,
    @SerializedName("Redirect"         ) var Redirect         : String?                  = null,
    @SerializedName("RelatedTopics"    ) var Character         : ArrayList<Character>      = arrayListOf(),
    @SerializedName("Results"          ) var Results          : ArrayList<String>        = arrayListOf(),
    @SerializedName("Type"             ) var Type             : String?                  = null,
    @SerializedName("meta"             ) var meta             : Meta?                    = Meta()
)