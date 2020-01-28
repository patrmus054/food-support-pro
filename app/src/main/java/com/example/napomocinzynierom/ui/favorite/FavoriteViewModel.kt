package com.example.napomocinzynierom.ui.favorite

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

class FavoriteViewModel : ViewModel() {

    var _item: MutableLiveData<List<Magazine>>
    private var viewModelJob = Job()
    private val corountineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    companion object{
        var isIntrnet: Boolean = true
        var page: Int = 1
        var limit: Int = 15
        var mMagazine: Magazine? = null
    }

    fun setMagazine( magazine: Magazine){
        mMagazine = magazine
    }
    fun getMagazineId(): String? = mMagazine?.id
    init {
        _item = MutableLiveData()
    }

    fun getData(): Repository = if(isIntrnet) Repository(RemoteDataSource()) else Repository(
        LocalDataSource()
    )

    val item: LiveData<List<Magazine>> get() = _item

    fun getFavoriteMagazines(userId: String){
        corountineScope.launch {
            val result = getData().getMagazinesByUserId(userId)
            _item.value = result
        }
    }

    fun getMagazinesWithRange(max: Int, min: Int){
        corountineScope.launch {
            val result = getData().getMagazinesByPoints(max, min)
            _item.value = result
        }
    }

}