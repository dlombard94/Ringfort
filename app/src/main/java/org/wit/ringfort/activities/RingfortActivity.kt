package org.wit.ringfort.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ringfort.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.ringfort.R
import org.wit.ringfort.main.MainApp
import org.wit.ringfort.models.RingfortModel
import java.util.ArrayList

class RingfortActivity : AppCompatActivity(), AnkoLogger {


    var ringfort = RingfortModel()
    lateinit var app: MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ringfort)
        info("Ringfort Activity started..")

        btnAdd.setOnClickListener() {
            ringfort.title = ringfortTitle.text.toString()
            ringfort.description = description.text.toString()

            if (ringfort.title.isNotEmpty()) {
                app.ringforts.add(ringfort.copy())
                info("add Button Pressed: $ringfortTitle")
                for (i in app.ringforts.indices) {
                    info("Placemark[$i]:${app.ringforts[i]}")
                }
            }
            else {
                toast ("Please Enter a title")
            }
        }
    }
}
