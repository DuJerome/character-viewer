package com.sample.thewire.model

import com.google.gson.annotations.SerializedName

data class Meta (
    @SerializedName("attribution"      ) var attribution     : String?              = null,
    @SerializedName("blockgroup"       ) var blockgroup      : String?              = null,
    @SerializedName("created_date"     ) var createdDate     : String?              = null,
    @SerializedName("description"      ) var description     : String?              = null,
    @SerializedName("designer"         ) var designer        : String?              = null,
    @SerializedName("dev_date"         ) var devDate         : String?              = null,
    @SerializedName("dev_milestone"    ) var devMilestone    : String?              = null,
    @SerializedName("developer"        ) var developer       : ArrayList<Developer> = arrayListOf(),
    @SerializedName("example_query"    ) var exampleQuery    : String?              = null,
    @SerializedName("id"               ) var id              : String?              = null,
    @SerializedName("is_stackexchange" ) var isStackexchange : String?              = null,
    @SerializedName("js_callback_name" ) var jsCallbackName  : String?              = null,
    @SerializedName("live_date"        ) var liveDate        : String?              = null,
    @SerializedName("maintainer"       ) var maintainer      : Maintainer?          = Maintainer(),
    @SerializedName("name"             ) var name            : String?              = null,
    @SerializedName("perl_module"      ) var perlModule      : String?              = null,
    @SerializedName("producer"         ) var producer        : String?              = null,
    @SerializedName("production_state" ) var productionState : String?              = null,
    @SerializedName("repo"             ) var repo            : String?              = null,
    @SerializedName("signal_from"      ) var signalFrom      : String?              = null,
    @SerializedName("src_domain"       ) var srcDomain       : String?              = null,
    @SerializedName("src_id"           ) var srcId           : Int?                 = null,
    @SerializedName("src_name"         ) var srcName         : String?              = null,
    @SerializedName("src_options"      ) var srcOptions      : SrcOptions?          = SrcOptions(),
    @SerializedName("src_url"          ) var srcUrl          : String?              = null,
    @SerializedName("status"           ) var status          : String?              = null,
    @SerializedName("tab"              ) var tab             : String?              = null,
    @SerializedName("topic"            ) var topic           : ArrayList<String>    = arrayListOf(),
    @SerializedName("unsafe"           ) var unsafe          : Int?                 = null
)