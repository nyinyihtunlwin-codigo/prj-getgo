package com.nyinyihtunlwin.prj_getgo.details

import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.nyinyihtunlwin.prj_getgo.R
import com.nyinyihtunlwin.prj_getgo.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity(), OnMapReadyCallback {

    companion object {
        fun newInstance(context: Context): Intent {
            val intent = Intent(context, DetailsActivity::class.java)
            return intent
        }
    }

    private lateinit var binding: ActivityDetailsBinding
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        imageList.add(SlideModel(R.drawable.ic_placeholder_car))
        binding.imageSlider.setImageList(imageList)
        binding.mapView.onCreate(null)
        savedInstanceState?.let {
            binding.mapView.onCreate(it.getBundle("a"))
        }

        binding.mapView.getMapAsync(this)

        binding.ivBack.setOnClickListener { onBackPressed() }
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        val mapViewBundle = outState.getBundle("a")
        mapViewBundle?.let {
            outState.putBundle("a", it)
        }
        binding.mapView.onSaveInstanceState(outState)
    }

    override fun onStart() {
        super.onStart()
        binding.mapView.onStart()
    }

    override fun onResume() {
        super.onResume()
        binding.mapView.onResume()
    }

    override fun onStop() {
        super.onStop()
        binding.mapView.onStop()
    }

    override fun onPause() {
        super.onPause()
        binding.mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        binding.mapView.onLowMemory()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.setMaxZoomPreference(12F)

        val mCustomMarker = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(
                R.layout.view_custom_marker_car, null
            )

        val loc = LatLng(16.894784, 96.158052)
        val marker = mMap.addMarker(
            MarkerOptions().position(loc)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerFromView(mCustomMarker)))
        )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc, 14F))
    }

    private fun getMarkerFromView(view: View): Bitmap {
        view.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
        view.buildDrawingCache()
        val bitmap =
            Bitmap.createBitmap(view.measuredWidth, view.measuredHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE, PorterDuff.Mode.SRC_IN)
        val drawable = view.background
        drawable?.draw(canvas)
        view.draw(canvas)
        return bitmap
    }
}