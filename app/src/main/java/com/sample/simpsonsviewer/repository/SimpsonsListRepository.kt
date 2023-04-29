package com.sample.simpsonsviewer.repository

import com.sample.simpsonsviewer.model.Character
import com.sample.simpsonsviewer.network.SimpsonsListServices
import javax.inject.Inject

class SimpsonsListRepository @Inject constructor(
    private val simpsonsListServices: SimpsonsListServices
) {
    fun getSimpsons(): ArrayList<Character> {
        return simpsonsListServices.getSimpsonsCharactersList().blockingGet().characters
    }
}