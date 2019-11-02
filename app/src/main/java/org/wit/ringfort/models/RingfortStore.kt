package org.wit.ringfort.models

interface RingfortStore {
    fun findAll(): List<RingfortModel>
    fun create(placemark: RingfortModel)
}