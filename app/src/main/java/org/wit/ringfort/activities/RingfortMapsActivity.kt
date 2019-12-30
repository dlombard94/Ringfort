package org.wit.placemark.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_ringfort_maps.*
import org.wit.ringfort.R

class PlacemarkMapsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringfort_maps)
        toolbar.title = title
        setSupportActionBar(toolbar)
    }
}
