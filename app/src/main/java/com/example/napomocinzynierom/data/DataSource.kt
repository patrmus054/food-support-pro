package com.example.napomocinzynierom.data

import com.example.napomocinzynierom.data.remote.LoginResponde
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.Result
import com.example.napomocinzynierom.data.remote.LoggedInUser

interface DataSource {

    //magazine
    suspend fun getMagazines(): List<Magazine>
    suspend fun getMagazines(page: Int, limit: Int): List<Magazine>
    suspend fun getMagazines(page: Int, limit: Int, title: String): List<Magazine>
    suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int): List<Magazine>
    suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine>
    suspend fun getMagazines(limit: Int, title: String): List<Magazine>
    suspend fun getMagazines(limit: Int, title: String, maxPoints: Int): List<Magazine>
    suspend fun getMagazines(limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine>
    suspend fun getMagazines(title: String): List<Magazine>
    suspend fun getMagazines(title: String, maxPoints: Int): List<Magazine>
    suspend fun getMagazines(title: String, maxPoints: Int, minPoints: Int): List<Magazine>
    suspend fun getMagazinesByMaxPoints(maxPoints: Int): List<Magazine>
    suspend fun getMagazinesByminPoints(minPoints: Int): List<Magazine>
    suspend fun getMagazinesByPoints(maxPoints: Int, minPoints: Int): List<Magazine>

    //login
    suspend fun authoriseCredentials(login: String, password: String): LoginResponde
    suspend fun logout()
    suspend fun login(username: String, password: String): Result<LoggedInUser>

}