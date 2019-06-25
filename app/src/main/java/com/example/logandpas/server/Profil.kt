package com.example.logandpas.server

import com.google.gson.Gson

class Profil() {

    constructor(
        mail: String,
        status: String,
        firstName: String,
        lastName: String,
        birthDate: String,
        notes: String
    ) : this()

    fun john(): String? {
        val john = Profil(
            "john@domain.tld",
            "ok",
            "John",
            "Doe",
            "01.01.1980",
            "dkjdshjdkfndkjfnkdsjfkdjfkdsjfhjkfhdskjksdj fdshfbsdjhsdbsdfh dshfs sdjsd jhsd fsdhjfsj fsf dsjsv dsfhdsiv sdsudv sdsdsdhhsd."
        )
        val gsonError = Gson()
        return gsonError.toJson(john)
    }

    fun jane(): String? {
        val jane = Profil(
            "jane@domain.tld",
            "ok",
            "Jane",
            "Doe",
            "03.03.1990",
            "dkjdshjdkfndkjfnkdsjfkdjfkdsjfhjkfhdskjksdj fdshfbsdjhsdbsdfh dshfs sdjsd jhsd fsdhjfsj fsf dsjsv dsfhdsiv sdsudv sdsdsdhhsd."
        )
        val gsonError = Gson()
        return gsonError.toJson(jane)
    }
}