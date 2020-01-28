package com.example.napomocinzynierom

import com.example.napomocinzynierom.data.DataSource
import com.example.napomocinzynierom.data.remote.*

class Repository(private val dataSource: DataSource):
    DataSource {

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
    override suspend fun getMagazinesByPoints(maxPoints: Int, minPoints: Int): List<Magazine> = dataSource.getMagazinesByPoints(maxPoints, minPoints)

    //login
    override suspend fun authoriseCredentials(login: String, password: String): LoginResponde {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override suspend fun logout() {
        user = null
        dataSource.logout()
    }

    override suspend fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    override suspend fun getMagazineById(id: String): Magazine = dataSource.getMagazineById(id)
    override suspend fun getMagazinesByUserId(id: String): List<Magazine> = dataSource.getMagazinesByUserId(id)


    override suspend fun addMagazine(userID: String, magazineID: String): AddMagazineRespond = addMagazine(userID, magazineID)
    override suspend fun addUser(
        login: String,
        password: String,
        firstName: String,
        lastName: String
    ): SignUpResponde {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var user: LoggedInUser? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = null
    }


    private fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser
    }

}