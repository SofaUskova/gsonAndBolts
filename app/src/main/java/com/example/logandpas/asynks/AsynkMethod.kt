package com.example.logandpas.asynks

import android.content.Context
import android.widget.TextView
import bolts.Task
import com.example.logandpas.server.Server
import com.example.logandpas.utils.setError
import com.google.gson.Gson
import com.google.gson.JsonObject

class AsynkMethod(
    var login: String,
    var password: String,
    val textView: TextView
) {

    fun fetchAsync(): Task<String?>? {
        var token = -1
        var gson: JsonObject? = null
        return Task.callInBackground {
            /*val url = URL("http://pub.zame-dev.org/senla-training-addition/lesson-21.php?method=login")
            val con = url.openConnection() as HttpURLConnection

            BufferedReader(InputStreamReader(con.inputStream)).use { `in` ->
                var inputLine = `in`.readLine()
                val content = StringBuilder()
                while (inputLine != null) {
                    content.append(inputLine)
                    inputLine = `in`.readLine()
                }
                return content.toString()
            }

            val parameters = HashMap<String, String>()
            parameters["email"] = login
            parameters["password"] = password

            con.doOutput = true
            val out = DataOutputStream(con.outputStream)
            out.writeBytes(getParamsString(parameters))
            out.flush()
            out.close()*/

            val answer = Server().serverRun(login, password.toInt())
            gson = Gson().fromJson(answer, JsonObject::class.java)

        }.continueWith {
            if (gson?.get("status")?.asString == "error") {
               return@continueWith setError("Error on Server", textView)
            }
        }.onSuccess {
            token = gson?.get("token")?.asInt!!
            return@onSuccess Server().getProfil(token)
        }
    }

    /*private fun getParamsString(params: HashMap<String, String>): String {
        val result = StringBuilder()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            params.forEach { name, value ->
                try {
                    result.append(URLEncoder.encode(name, "UTF-8"))
                    result.append('=')
                    result.append(URLEncoder.encode(value, "UTF-8"))
                    result.append('&')
                } catch (e: UnsupportedEncodingException) {
                    e.printStackTrace()
                }
            }
        }

        val resultString = result.toString()
        return if (!resultString.isEmpty())
            resultString.substring(0, resultString.length - 1)
        else
            resultString
    }*/

}