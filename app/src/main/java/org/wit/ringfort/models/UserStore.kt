package org.wit.ringfort.models

interface UserStore {
    fun register(user: UserModel)
    fun findAll(): List<UserModel>
}