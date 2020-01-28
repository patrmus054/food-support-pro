package com.example.napomocinzynierom.ui.home

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.databinding.ItemListHomeBinding
import com.example.napomocinzynierom.ui.home.HomeFragment.Companion.homeViewModel
import kotlinx.android.synthetic.main.item_list_home.view.*

class HomeAdapter(private val list: MutableList<Magazine>)
    :RecyclerView.Adapter<HomeViewHolder>(){

    companion object{
        val TAG: String = "HomeAdapter"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = DataBindingUtil.inflate<ItemListHomeBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_list_home, parent, false)

        return HomeViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val magazine: Magazine = list[position]
        holder.bind(magazine, object : MagazineListener{
            override fun onMagazineSelected(magazine: Magazine) {
                Log.w(TAG, magazine.title1 + " " + magazine.points)
                homeViewModel.setMagazine(magazine)
                homeViewModel.callSignIn()
            }
        })
    }


    fun setList(newList: List<Magazine>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}

class HomeViewHolder(private val binding: ItemListHomeBinding) : RecyclerView.ViewHolder(binding.root) {
    private var mTitleView: TextView? = null
    private var mIssn: TextView? = null
    private var mPoints: TextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.tv_home_title)
        mIssn = itemView.findViewById(R.id.tv_home_issn)
        mPoints = itemView.findViewById(R.id.tv_home_points)
    }

    fun bind(mMagazine: Magazine, magazineListener: MagazineListener) {
        with(binding)
        {
            magazine = mMagazine
            listener = magazineListener
            mTitleView?.text = mMagazine.title1
            mIssn?.text = mMagazine.issn
            var sum: Int = 0
            mMagazine.points.forEach { p -> sum = sum + p.value}
            mPoints?.text = sum.toString()
            executePendingBindings()
        }
    }
}
interface MagazineListener {
    fun onMagazineSelected(mMagazine: Magazine)
}