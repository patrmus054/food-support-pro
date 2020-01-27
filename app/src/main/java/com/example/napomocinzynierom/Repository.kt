package com.example.napomocinzynierom

import com.example.napomocinzynierom.data.remote.Magazine

class Repository(private val dataSource: DataSource): DataSource {

    override suspend fun getMagazines(): List<Magazine> = dataSource.getMagazines()
    override suspend fun getMagazines(page: Int, limit: Int): List<Magazine> = dataSource.getMagazines(page, limit)
    override suspend fun getMagazines(page: Int, limit: Int, title: String): List<Magazine> = dataSource.getMagazines(page, limit, title)
    override suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int): List<Magazine> = dataSource.getMagazines(page, limit, title, maxPoints)
    override suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine> = dataSource.getMagazines(page, limit, title, maxPoints, minPoints)
    override suspend fun getMagazines(limit: Int, title: String): List<Magazine> = dataSource.getMagazines(limit, title)
    override suspend fun getMagazines(limit: Int, title: String, maxPoints: Int): List<Magazine> = dataSource.getMagazines(limit, title, maxPoints)
    override suspend fun getMagazines(limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine> = dataSource.getMagazines(limit, title, maxPoints, minPoints)
    override suspend fun getMagazines(title: String): List<Magazine> = dataSource.getMagazines(title)
    override suspend fun getMagazines(title: String, maxPoints: Int): List<Magazine> = dataSource.getMagazines(title, maxPoints)
    override suspend fun getMagazines(title: String, maxPoints: Int, minPoints: Int): List<Magazine> = dataSource.getMagazines(title, maxPoints, minPoints)
    override suspend fun getMagazinesByMaxPoints(maxPoints: Int): List<Magazine> = dataSource.getMagazinesByMaxPoints(maxPoints)
    override suspend fun getMagazinesByminPoints(minPoints: Int): List<Magazine> = dataSource.getMagazinesByminPoints(minPoints)
    override suspend fun getMagazinesByPoints(maxPoints: Int, minPoints: Int): List<Magazine> = dataSource.getMagazines(maxPoints, minPoints)

}