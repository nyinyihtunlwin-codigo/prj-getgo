package com.nyinyihtunlwin.prj_getgo.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.nyinyihtunlwin.prj_getgo.databinding.ActivitySearchResultsBinding

class SearchResultsActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, SearchResultsActivity::class.java)
            return intent
        }
    }

    private lateinit var binding: ActivitySearchResultsBinding
    private lateinit var mAdapter: CarAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchResultsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mAdapter = CarAdapter(this, object : CarDelegate {
            override fun onTapCar(car: Car) {

            }
        })
        binding.rvSearchResults.adapter = mAdapter
        binding.rvSearchResults.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}