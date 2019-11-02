package org.wit.ringfort.models

import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class RingfortMemStore : RingfortStore, AnkoLogger {

    val ringforts = ArrayList<RingfortModel>()

    override fun findAll(): List<RingfortModel> {
        return ringforts
    }

    override fun create(placemark: RingfortModel) {
        ringforts.add(placemark)
        logAll()
    }

    fun logAll() {
        ringforts.forEach{ info("${it}") }
    }
}