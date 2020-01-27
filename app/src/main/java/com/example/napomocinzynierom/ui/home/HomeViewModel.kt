package com.example.napomocinzynierom.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.napomocinzynierom.Repository
import com.example.napomocinzynierom.data.local.LocalDataSource
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.data.remote.RemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text


    var _item: MutableLiveData<List<Magazine>>
    private var viewModelJob = Job()
    private val corountineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    companion object{
        var isIntrnet: Boolean = true
        var page: Int = 1
        var limit: Int = 15
    }

    init {
        _item = MutableLiveData()
    }

    fun getData(): Repository = if(isIntrnet) Repository(RemoteDataSource()) else Repository(LocalDataSource())

    val item: LiveData<List<Magazine>> get() = _item

    fun getAllMagazines(){
        corountineScope.launch {
            val result = getData().getMagazines()
            _item.value = result
        }
    }

}