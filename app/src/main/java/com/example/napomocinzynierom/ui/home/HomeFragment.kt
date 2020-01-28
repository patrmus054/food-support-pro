package com.example.napomocinzynierom.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.SecificsActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var mMagazineList: MutableList<Magazine>
    lateinit var listAdapter: HomeAdapter


    companion object{
        fun newInstance(): HomeFragment = newInstance()
        lateinit var homeViewModel: HomeViewModel
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
        homeViewModel.getMagazinesBySearch()

        homeViewModel.showSignIn.observe(this, Observer {
            val intent = Intent(activity, SecificsActivity::class.java)
            startActivity(intent)
        })
    }


}