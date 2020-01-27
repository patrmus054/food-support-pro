package com.example.napomocinzynierom.ui.home

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.data.remote.Magazine
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.item_list_home.*

class HomeFragment : Fragment() {

    lateinit var mMagazineList: MutableList<Magazine>
    lateinit var listAdapter: HomeAdapter
    private lateinit var homeViewModel: HomeViewModel

    companion object{
        fun newInstance(): HomeFragment = newInstance()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?
    ): View? {homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)



        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMagazineList = mutableListOf()
        listAdapter = HomeAdapter(mMagazineList)

        rv_home.apply {
            layoutManager =  LinearLayoutManager(activity)
            adapter = listAdapter
        }
        homeViewModel.item.observe(this, Observer {
            listAdapter.setList(it)
        })
        homeViewModel.getAllMagazines()


    }
}