package com.example.napomocinzynierom.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpService {
    @POST("user/signup/")
    fun signNewUser(@Body signUpBody: SignUpBody): Call<SignUpResponde>
}