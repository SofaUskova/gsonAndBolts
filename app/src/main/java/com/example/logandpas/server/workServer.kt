package com.example.logandpas.server

import com.google.gson.Gson

fun answerError() : String {
    val error = ServerAnswerError("error", 404, "error on server")
    val gsonError = Gson()
    return gsonError.toJson(error)
}

fun answerOk(login: String) : String {
    val token = if (login == "john@domain.tld") 0 else 1
    val ok = ServerAnswerOk("ok", token)
    val gsonError = Gson()
    return gsonError.toJson(ok)
}