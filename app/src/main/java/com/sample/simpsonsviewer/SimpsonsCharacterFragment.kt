package com.sample.simpsonsviewer

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import com.sample.R
import com.sample.databinding.FragmentCharacterBinding
import com.sample.simpsonsviewer.viewmodel.SimpsonsListViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SimpsonsCharacterFragment @Inject constructor(
): FragmentActivity(R.layout.fragment_character) {
    private lateinit var binding: FragmentCharacterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentCharacterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: SimpsonsListViewModel = ViewModelProvider(this).get(SimpsonsListViewModel::class.java)

        val position = intent?.extras?.getInt("position")
        val character = viewModel.characterList[position ?: 1]

        Picasso.get().load(
            "https://upload.wikimedia.org/wikipedia/commons/d/d1/Image_not_available.png"
        ).into(binding.characterImage)
        /* The API in providing the image URL does not have a valid url. The images are stored
            locally on someone elses machine and so I skipped that part and went with a fall image
            sorry
        Glide.with(this).load(
            Uri.parse(character.Icon?.URL
            )
        ).into(binding.characterImage)
        */
        binding.characterDescription.text = character.description
        binding.characterName.text = character.Text
    }
}