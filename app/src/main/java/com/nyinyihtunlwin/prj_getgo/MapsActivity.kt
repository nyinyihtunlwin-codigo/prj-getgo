package com.nyinyihtunlwin.prj_getgo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.nyinyihtunlwin.prj_getgo.databinding.ActivityMapsBinding
import com.nyinyihtunlwin.prj_getgo.search.SearchResultsActivity

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.btnGo.setOnClickListener {
            startActivity(SearchResultsActivity.newInstance(this))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val mCustomMarker = (getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
            .inflate(
                R.layout.view_custom_marker, null
            )

        val builder = LatLngBounds.builder()
        val loc1 = LatLng(16.87644, 96.17150)
        val marker1 = mMap.addMarker(
            MarkerOptions().position(loc1)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerFromView(mCustomMarker, "2")))
        )
        val loc2 = LatLng(16.894784, 96.158052)
        val marker2 = mMap.addMarker(
            MarkerOptions().position(loc2)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerFromView(mCustomMarker, "3")))
        )

        val loc3 = LatLng(16.886238, 96.188625)
        val marker3 = mMap.addMarker(
            MarkerOptions().position(loc3)
                .icon(BitmapDescriptorFactory.fromBitmap(getMarkerFromView(mCustomMarker, "5")))
        )
        builder.include(marker1.position)
        builder.include(marker2.position)
        builder.include(marker3.position)
        //  mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(loc1, 14F))

        val bounds = builder.build()
        val width = resources.displayMetrics.widthPixels
        val height = resources.displayMetrics.heightPixels
        val padding =
            (width * 0.12).toInt() // offset from edges of the map 12% of screen
        val cu = CameraUpdateFactory.newLatLngBounds(bounds, width, height, padding)
        mMap.moveCamera(cu)

    }

    private fun getMarkerFromView(view: View, count: String): Bitmap {
        val tvCount: TextView = view.findViewById(R.id.tvCount)
        tvCount.text = count
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