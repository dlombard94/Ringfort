package org.wit.ringfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.ringfort.models.RingfortModel
import java.util.ArrayList

class MainApp : Application(), AnkoLogger {

    val ringforts = ArrayList<RingfortModel>()

    override fun onCreate() {
        super.onCreate()
        info("Ringfort started")
        ringforts.add(RingfortModel("One", "About one..."))
        ringforts.add(RingfortModel("Two", "About two..."))
        ringforts.add(RingfortModel("Three", "About three..."))
    }
}