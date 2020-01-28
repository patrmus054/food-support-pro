package com.example.napomocinzynierom.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.napomocinzynierom.Repository
import com.example.napomocinzynierom.SingleLiveEvent
import com.example.napomocinzynierom.data.local.LocalDataSource
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _showSignIn = MutableLiveData<Boolean?>()
    val showSignIn: LiveData<Boolean?>
        get() = _showSignIn

    fun callSignIn() {
        _showSignIn.value = true
    }

    var _item: MutableLiveData<List<Magazine>> = MutableLiveData()
    private var viewModelJob = Job()
    private val corountineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    companion object{
        var isIntrnet: Boolean = true
        var page: Int = 1
        var limit: Int = 15
        var title: String = ""
        var maxPoints: Int = 140
        var minPoints: Int = 0
        lateinit var mMagazine:Magazine
    }

    fun setMagazine( magazine: Magazine){
        mMagazine = magazine
    }
    fun getMagazineId(): String? = mMagazine.id

    fun getData(): Repository = if(isIntrnet) Repository(RemoteDataSource()) else Repository(LocalDataSource())

    val item: LiveData<List<Magazine>> get() = _item

    fun getAllMagazines(){
        corountineScope.launch {
            val result = getData().getMagazines()
            _item.value = result
        }
    }

    fun getMagazinesBySearch(){
        corountineScope.launch {
            val result = getData().getMagazines(page, limit, title, maxPoints, minPoints)
            _item.value = result
        }
    }

    fun setSearchParams(pPage: Int, lLimit: Int, tTitle: String, mMaxPoints: Int, mMinPoints: Int){
        page = pPage
        limit = lLimit
        title = tTitle
        maxPoints = mMaxPoints
        minPoints = mMinPoints
    }

}