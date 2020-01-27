package com.example.napomocinzynierom.data.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MagazineService {
    @GET("magazines/")
    fun getCurrentMagazineData(@Query("page") page: Int, @Query("limit") limit: Int,
                               @Query("title")title: String, @Query("maxPoints")maxPoints: Int,
                               @Query("minPoints")minPoints: Int): Call<MagazineResponde>
}