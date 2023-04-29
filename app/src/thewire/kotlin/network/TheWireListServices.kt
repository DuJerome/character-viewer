package com.sample.thewire.network

import com.sample.simpsonsviewer.model.SearchResults
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface TheWireListServices {

    @GET("?q=the+wire+characters&format=json")
    fun getTheWireCharactersList(): Single<SearchResults>
}