package com.example.logandpas.server

import com.google.gson.Gson

class Profil(
    val mail: String,
    val status: String,
    val firstName: String,
    val lastName: String,
    val birthDate: String,
    val notes: String
) {

    fun john(john: Profil): String? {
        val gson = Gson()
        return gson.toJson(john)
    }

    fun jane(jane: Profil): String? {
        val gson = Gson()
        return gson.toJson(jane)
    }
}