package org.wit.ringfort.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.wit.ringfort.helpers.*
import java.util.*

val JSON_FILE = "ringforts.json"
val gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val listType = object : TypeToken<java.util.ArrayList<RingfortModel>>() {}.type

fun generateRandomId(): Long {
    return Random().nextLong()
}

class RingfortJSONStore : RingfortStore, AnkoLogger {

    val context: Context
    var ringforts = mutableListOf<RingfortModel>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<RingfortModel> {
        return ringforts
    }

    override fun create(ringfort: RingfortModel) {
        ringfort.id = generateRandomId()
        ringforts.add(ringfort)
        serialize()
    }


    override fun update(ringfort: RingfortModel) {
        var foundRingfort: RingfortModel? = ringforts.find { p -> p.id == ringfort.id }
        if (foundRingfort != null) {
            foundRingfort.title = ringfort.title
            foundRingfort.description = ringfort.description
            foundRingfort.image = ringfort.image
        }
        serialize()
    }

    override fun delete(ringfort: RingfortModel) {
        ringforts.remove(ringfort)
        serialize()
    }

    private fun serialize() {
        val jsonString = gsonBuilder.toJson(ringforts, listType)
        write(context, JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, JSON_FILE)
        ringforts = Gson().fromJson(jsonString, listType)
    }
}