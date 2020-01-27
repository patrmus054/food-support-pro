package com.example.napomocinzynierom.data.remote

import com.example.napomocinzynierom.DataSource
import com.example.napomocinzynierom.ui.home.HomeViewModel
import retrofit2.Retrofit
import retrofit2.await
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.max
import kotlin.math.min

class RemoteDataSource:DataSource {
    companion object{
        val BASE_URL = "http://publisher.freesher.ct8.pl/"
    }

    override suspend fun getMagazines(): List<Magazine> = getData(HomeViewModel.page,HomeViewModel.limit,"",100000,0)
    override suspend fun getMagazines(page: Int, limit: Int): List<Magazine> = getData(page, limit, "", 100000, 0)
    override suspend fun getMagazines(page: Int, limit: Int, title: String): List<Magazine> = getData(page, limit, title, 100000,0)
    override suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int): List<Magazine> = getData(page, limit, title, maxPoints, 0)
    override suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine> = getData(page, limit, title, maxPoints, minPoints)
    override suspend fun getMagazines(limit: Int, title: String): List<Magazine> = getData(HomeViewModel.page, limit, title, 100000, 0)
    override suspend fun getMagazines(limit: Int, title: String, maxPoints: Int): List<Magazine> = getData(HomeViewModel.page, HomeViewModel.limit, title, maxPoints, 0)
    override suspend fun getMagazines(title: String): List<Magazine> = getData(HomeViewModel.page, HomeViewModel.limit, title, 0, 100000)
    override suspend fun getMagazines(title: String, maxPoints: Int): List<Magazine> = getData(HomeViewModel.page, HomeViewModel.limit, title, 0, maxPoints)
    override suspend fun getMagazines(title: String, maxPoints: Int, minPoints: Int): List<Magazine> = getMagazines(HomeViewModel.page,HomeViewModel.limit, title,maxPoints, minPoints)
    override suspend fun getMagazinesByMaxPoints(maxPoints: Int): List<Magazine> = getMagazines(HomeViewModel.page, HomeViewModel.limit, "", maxPoints, 0)
    override suspend fun getMagazinesByminPoints(minPoints: Int): List<Magazine> = getMagazines(HomeViewModel.page, HomeViewModel.limit, "", minPoints, 0)
    override suspend fun getMagazinesByPoints(maxPoints: Int, minPoints: Int): List<Magazine> = getMagazines(HomeViewModel.page, HomeViewModel.limit, "", maxPoints, minPoints)


    override suspend fun getMagazines(
        limit: Int,
        title: String,
        maxPoints: Int,
        minPoints: Int
    ): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    internal suspend fun getData(page: Int, limit: Int, title: String, maxPoint: Int, minPoint: Int): List<Magazine>{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val service = retrofit.create(MagazineService::class.java)
        val call = service.getCurrentMagazineData(page, limit, title, maxPoint, minPoint)
        var result = call.await()
        return result.magazines

    }

}