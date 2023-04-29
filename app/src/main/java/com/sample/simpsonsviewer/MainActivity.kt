package com.sample.simpsonsviewer

import android.os.Bundle
import android.widget.SearchView
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.R
import com.sample.databinding.ActivityMainBinding
import com.sample.simpsonsviewer.adapter.SimpsonsListAdapter
import com.sample.simpsonsviewer.viewmodel.SimpsonsListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : FragmentActivity(R.layout.activity_main) {
    private val simpsonsListViewModel: SimpsonsListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SimpsonsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setUpRecyclerView(binding)
        setUpSearchListener(binding, adapter)
    }

    private fun setUpRecyclerView(binding: ActivityMainBinding){
        adapter = SimpsonsListAdapter(this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
        adapter.submitData(
            lifecycle,
            PagingData.from(simpsonsListViewModel.characterList)
        )
    }

    private fun setUpSearchListener(binding: ActivityMainBinding, adapter: SimpsonsListAdapter){
        binding.editTextSearch.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                adapter.submitData(
                    lifecycle,
                    PagingData.from(
                        simpsonsListViewModel.characterList.filter {
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
                            simpsonsListViewModel.characterList
                        )
                    )
                }
                return true
            }
        })
    }

}