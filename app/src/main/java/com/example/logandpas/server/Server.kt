package com.example.logandpas.server

class Server {
    private val data = mapOf("john@domain.tld" to 123123, "jane@domain.tld" to 12345)

    fun serverRun(login: String, password: Int): String {
        if (data.contains(login))
            if (data.getValue(login) == password)
                return answerOk(login)

        return answerError()
    }

    fun getProfil(token: Int): String? {
        return if (token == 0) {
            val johnName = Profil(
                    "john@domain.tld",
            "ok",
            "John",
            "Doe",
            "01.01.1980",
            "dkjdshjdkfndkjfnkdsjfkdjfkdsjfhjkfhdskjksdj fdshfbsdjhsdbsdfh dshfs sdjsd jhsd fsdhjfsj fsf dsjsv dsfhdsiv sdsudv sdsdsdhhsd."
            )
            johnName.john(johnName)
        } else {
            val janeName = Profil(
                "jane@domain.tld",
                "ok",
                "Jane",
                "Doe",
                "03.03.1990",
                "dkjdshjdkfndkjfnkdsjfkdjfkdsjfhjkfhdskjksdj fdshfbsdjhsdbsdfh dshfs sdjsd jhsd fsdhjfsj fsf dsjsv dsfhdsiv sdsudv sdsdsdhhsd."
            )
            janeName.jane(janeName)
        }
    }

}