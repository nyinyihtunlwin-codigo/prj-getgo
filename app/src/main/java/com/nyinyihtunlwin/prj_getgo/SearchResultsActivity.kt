package com.nyinyihtunlwin.prj_getgo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class SearchResultsActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, SearchResultsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_results)
    }
}