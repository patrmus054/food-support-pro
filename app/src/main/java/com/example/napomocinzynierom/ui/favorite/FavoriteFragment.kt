package com.example.napomocinzynierom.ui.favorite

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
import com.example.napomocinzynierom.ui.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_favorites.*


class FavoriteFragment : Fragment() {

    private lateinit var mMagazines: MutableList<Magazine>
    private lateinit var favoriteViewModel: FavoriteViewModel
    lateinit var listAdapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? { favoriteViewModel =
            ViewModelProviders.of(this).get(FavoriteViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mMagazines = mutableListOf()
        listAdapter = FavoriteAdapter(mMagazines)

        rv_favorite.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = listAdapter
        }
        favoriteViewModel.item.observe(this, Observer {
            listAdapter.setList(it)
        })
        favoriteViewModel.getFavoriteMagazines(LoginActivity.userID!!)

    }
}
