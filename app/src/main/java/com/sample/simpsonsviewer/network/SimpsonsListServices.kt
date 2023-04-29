package com.sample.simpsonsviewer.network

import com.sample.simpsonsviewer.model.SearchResults
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface SimpsonsListServices {
    @GET("?q=simpsons+characters&format=json")
    fun getSimpsonsCharactersList(): Single<SearchResults>
}