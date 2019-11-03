package org.wit.ringfort.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.ringfort.models.*
import java.util.ArrayList

class MainApp : Application(), AnkoLogger {


    lateinit var ringforts: RingfortStore
    lateinit var users: UserStore

    override fun onCreate() {
        super.onCreate()
        ringforts = RingfortJSONStore(applicationContext)
        users = UserJSONStore(applicationContext)

        info("Ringfort started")
    }
}