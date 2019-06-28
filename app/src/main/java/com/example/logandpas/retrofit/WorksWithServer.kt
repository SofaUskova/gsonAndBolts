package com.example.logandpas.retrofit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WorksWithServer(
    var login: String,
    var password: String
) {

    fun serverStart(): String? {
        var usersProfile: String? = null
        val retrofit = Retrofit.Builder()
            .baseUrl("http://pub.zame-dev.org/senla-training-addition/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(Api::class.java)
        val body = RegistrationBody(login, password)
        val call = service.registerUser(body)

        call.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                usersProfile = "no null"
            }

            override fun onResponse(call: Call<RegistrationResponse>, response: Response<RegistrationResponse>) {
                if (response.isSuccessful) {
                    usersProfile = response.message().toString()
                } else {
                    usersProfile = "error on server"
                }
            }
        })
            return usersProfile
    }
}