package com.sample.thewire

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.R
import com.sample.databinding.ActivityMainBinding
import com.sample.simpsonsviewer.adapter.SimpsonsListAdapter
import com.sample.thewire.adapter.TheWireListAdapter
import com.sample.thewire.viewmodel.TheWireListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity(R.layout.activity_main) {
    private val theWireListViewModel: TheWireListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: TheWireListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpRecyclerView(binding)
        setUpSearchListener(binding, adapter)
    }

    private fun setUpRecyclerView(binding: ActivityMainBinding){
        adapter = TheWireListAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.submitData(
            lifecycle,
            PagingData.from(theWireListViewModel.characterList)
        )
    }

    private fun setUpSearchListener(binding: ActivityMainBinding, adapter: TheWireListAdapter){
        binding.editTextSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.submitData(
                    lifecycle,
                    PagingData.from(
                        theWireListViewModel.characterList.filter {
                            it.Text?.contains(
                                binding.editTextSearch.query.toString(),
                                true
                            ) == true
                        }
                    )
                )
                adapter.notifyDataSetChanged()
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText == ""){
                    adapter.submitData(
                        lifecycle,
                        PagingData.from(
                            theWireListViewModel.characterList
                        )
                    )
                }
                return true
            }
        })
    }

}