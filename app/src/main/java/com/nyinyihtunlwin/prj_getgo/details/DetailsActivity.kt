package com.nyinyihtunlwin.prj_getgo.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.nyinyihtunlwin.prj_getgo.R
import com.nyinyihtunlwin.prj_getgo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            return intent
        }
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        binding.imageSlider.setImageList(imageList)

        binding.ivBack.setOnClickListener { onBackPressed() }
    }
}