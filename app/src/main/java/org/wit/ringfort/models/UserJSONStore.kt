package org.wit.ringfort.models

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.jetbrains.anko.AnkoLogger
import org.wit.ringfort.helpers.exists
import org.wit.ringfort.helpers.read
import org.wit.ringfort.helpers.write
import java.util.*

val User_JSON_FILE = "users.json"
val user_gsonBuilder = GsonBuilder().setPrettyPrinting().create()
val user_listType = object : TypeToken<ArrayList<UserModel>>() {}.type

fun user_generateRandomId(): Long {
    return Random().nextLong()
}

class UserJSONStore : UserStore, AnkoLogger {

    val context: Context
    var users = mutableListOf<UserModel>()

    constructor (context: Context) {
        this.context = context
        if (exists(context, User_JSON_FILE)) {
            deserialize()
        }
    }

    override fun findAll(): MutableList<UserModel> {
        return users
    }



    override fun register(user: UserModel) {
        user.id = user_generateRandomId()
        users.add(user)
        serialize()
    }

    private fun serialize() {
        val jsonString = user_gsonBuilder.toJson(users, user_listType)
        write(context, User_JSON_FILE, jsonString)
    }

    private fun deserialize() {
        val jsonString = read(context, User_JSON_FILE)
        users = Gson().fromJson(jsonString, user_listType)
    }
}