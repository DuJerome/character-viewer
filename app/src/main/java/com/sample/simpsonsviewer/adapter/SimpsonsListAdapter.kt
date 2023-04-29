package com.sample.simpsonsviewer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.sample.R
import com.sample.databinding.ListItemCharacterBinding
import com.sample.simpsonsviewer.SimpsonsCharacterFragment
import com.sample.simpsonsviewer.model.Character

class SimpsonsListAdapter(
    private val context: Context
) : PagingDataAdapter<Character, SimpsonsListAdapter.ViewHolder>(COMPARATOR) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ListItemCharacterBinding = DataBindingUtil.bind(view)!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val character = getItem(position)

        val nameAndDescription = trim(character?.Text)

        character?.description = nameAndDescription[1]
        character?.Text = nameAndDescription[0]

        holder.binding.textViewName.text = character?.Text

        holder.binding.root.setOnClickListener {
            val nextFragmentIntent = Intent(context, SimpsonsCharacterFragment::class.java)
            nextFragmentIntent.putExtra("position", position)
            context.startActivity(nextFragmentIntent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item_character, parent, false)
        return ViewHolder(view)
    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
                return oldItem.Text == newItem.Text
            }
        }
    }

    private fun trim(text: String?): Array<String>{
        if (text.isNullOrBlank()) return arrayOf("", "")
        val index = text.indexOfFirst { it == '-' }
        return arrayOf(text.substring(0, index), text.substring(index+1))
    }
}