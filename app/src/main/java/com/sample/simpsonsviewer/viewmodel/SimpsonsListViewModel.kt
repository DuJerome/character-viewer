package com.sample.simpsonsviewer.viewmodel

import androidx.lifecycle.ViewModel
import com.sample.simpsonsviewer.model.Character
import com.sample.simpsonsviewer.repository.SimpsonsListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SimpsonsListViewModel @Inject constructor(
    private val simpsonsListRepository: SimpsonsListRepository
): ViewModel() {
    var characterList: ArrayList<Character> = getSimpsons()

    private fun getSimpsons(): ArrayList<Character> = simpsonsListRepository.getSimpsons()


}