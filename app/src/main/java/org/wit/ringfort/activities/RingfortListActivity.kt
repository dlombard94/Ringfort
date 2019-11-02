package org.wit.ringfort.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.wit.ringfort.R
import org.wit.ringfort.main.MainApp


class RingfortListActivity : AppCompatActivity() {

    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringfort_list)
        app = application as MainApp
    }
}