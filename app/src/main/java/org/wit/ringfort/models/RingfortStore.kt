package org.wit.ringfort.models

interface RingfortStore {
    fun findAll(): List<RingfortModel>
    fun create(ringfort: RingfortModel)
    fun update(ringfort: RingfortModel)
    fun delete(ringfort: RingfortModel)
    fun findById(id:Long) : RingfortModel?
}