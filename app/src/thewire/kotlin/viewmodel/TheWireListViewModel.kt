package com.sample.thewire.viewmodel

import androidx.lifecycle.ViewModel
import com.sample.simpsonsviewer.model.Character
import com.sample.thewire.repository.TheWireListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TheWireListViewModel @Inject constructor(
    private val theWireListRepository: TheWireListRepository
): ViewModel() {
    var characterList: ArrayList<Character> = getTheWireCharacters()

    private fun getTheWireCharacters(): ArrayList<Character> = theWireListRepository.getTheWireCharacters()
}