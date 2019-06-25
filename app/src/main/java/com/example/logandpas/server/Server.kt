package com.example.logandpas.server

class Server {
    private val data = mapOf("john@domain.tld" to 123123, "jane@domain.tld" to 12345)
    private var check = false

    fun serverRun(login: String, password: Int): String {
        if (data.contains(login))
            if (data.getValue(login) == password){
                check = true
                return answerOk(login)
            }

        return answerError()
    }

    fun getProfil(token: Int): String? {
        if (check) {
            return if (token == 0) {
                Profil().john()
            } else {
                Profil().jane()
            }
        }
       return ""
    }

}