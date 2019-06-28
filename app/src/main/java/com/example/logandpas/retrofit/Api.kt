package com.example.logandpas.retrofit

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("/lesson-21.php?method=login")
    fun registerUser(@Body registrationBody: RegistrationBody): Call<RegistrationResponse>
}