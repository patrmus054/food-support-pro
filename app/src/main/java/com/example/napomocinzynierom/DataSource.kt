package com.example.napomocinzynierom

import com.example.napomocinzynierom.data.remote.Magazine

interface DataSource {

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
}