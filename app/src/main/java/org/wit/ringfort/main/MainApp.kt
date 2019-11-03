package org.wit.ringfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.ringfort.models.RingfortJSONStore
import org.wit.ringfort.models.RingfortMemStore
import org.wit.ringfort.models.RingfortModel
import org.wit.ringfort.models.RingfortStore
import java.util.ArrayList

class MainApp : Application(), AnkoLogger {


    lateinit var ringforts: RingfortStore

    override fun onCreate() {
        super.onCreate()
        ringforts = RingfortJSONStore(applicationContext)

        info("Ringfort started")
    }
}