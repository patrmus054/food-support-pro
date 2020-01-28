package com.example.napomocinzynierom.data.local

import com.example.napomocinzynierom.data.DataSource
import com.example.napomocinzynierom.Result
import com.example.napomocinzynierom.data.remote.*

class LocalDataSource: DataSource {
    override suspend fun getMagazines(): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(page: Int, limit: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(page: Int, limit: Int, title: String): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines( page: Int,limit: Int,title: String, maxPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(page: Int, limit: Int, title: String, maxPoints: Int, minPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(limit: Int, title: String): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(limit: Int, title: String, maxPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines( limit: Int, title: String, maxPoints: Int,  minPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(title: String): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(title: String, maxPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazines(title: String, maxPoints: Int,  minPoints: Int ): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazinesByMaxPoints(maxPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazinesByminPoints(minPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazinesByPoints(maxPoints: Int, minPoints: Int): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun authoriseCredentials(login: String, password: String): LoginResponde {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun logout() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun login(username: String, password: String): Result<LoggedInUser> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazineById(id: String): Magazine {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun getMagazinesByUserId(id: String): List<Magazine> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addMagazine(userID: String, magazineID: String): AddMagazineRespond {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun addUser(
        login: String,
        password: String,
        firstName: String,
        lastName: String
    ): SignUpResponde {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}