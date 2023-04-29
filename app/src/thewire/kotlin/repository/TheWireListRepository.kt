package com.sample.thewire.repository

import com.sample.simpsonsviewer.model.Character
import com.sample.thewire.network.TheWireListServices
import javax.inject.Inject

class TheWireListRepository @Inject constructor(
    private val theWireListServices: TheWireListServices
) {
    fun getTheWireCharacters(): ArrayList<Character> {
        return theWireListServices.getTheWireCharactersList().blockingGet().characters
    }
}