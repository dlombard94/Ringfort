package org.wit.ringfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.ringfort.models.RingfortMemStore
import org.wit.ringfort.models.RingfortModel
import java.util.ArrayList

class MainApp : Application(), AnkoLogger {


    val ringforts = RingfortMemStore()

    override fun onCreate() {
        super.onCreate()
        info("Ringfort started")
    }
}