package com.example.napomocinzynierom.data.remote

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface LoginService {

    @POST("user/login")
    fun userAuthentication(@Body loginBody: LoginBody): Call<LoginResponde>
}