package org.wit.ringfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.wit.ringfort.R

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // my_child_toolbar is defined in the layout file
        setSupportActionBar(findViewById(R.id.toolbarSettings))

        // Get a support ActionBar corresponding to this toolbar and enable the Up button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}
