package com.sample.simpsonsviewer.model

import com.google.gson.annotations.SerializedName


data class SrcOptions (
  @SerializedName("directory"           ) var directory         : String? = null,
  @SerializedName("is_fanon"            ) var isFanon           : Int?    = null,
  @SerializedName("is_mediawiki"        ) var isMediawiki       : Int?    = null,
  @SerializedName("is_wikipedia"        ) var isWikipedia       : Int?    = null,
  @SerializedName("language"            ) var language          : String? = null,
  @SerializedName("min_abstract_length" ) var minAbstractLength : String? = null,
  @SerializedName("skip_abstract"       ) var skipAbstract      : Int?    = null,
  @SerializedName("skip_abstract_paren" ) var skipAbstractParen : Int?    = null,
  @SerializedName("skip_end"            ) var skipEnd           : String? = null,
  @SerializedName("skip_icon"           ) var skipIcon          : Int?    = null,
  @SerializedName("skip_image_name"     ) var skipImageName     : Int?    = null,
  @SerializedName("skip_qr"             ) var skipQr            : String? = null,
  @SerializedName("source_skip"         ) var sourceSkip        : String? = null,
  @SerializedName("src_info"            ) var srcInfo           : String? = null
)