package com.example.napomocinzynierom.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.ui.home.HomeAdapter.Companion.TAG

class HomeAdapter(private val list: MutableList<Magazine>)
    :RecyclerView.Adapter<HomeViewHolder>(){

    companion object{
        val TAG: String = "HomeAdapter"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val magazine: Magazine = list[position]
        holder.bind(magazine)
    }
    fun setList(newList: List<Magazine>){
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }
}

class HomeViewHolder(inflater: LayoutInflater, parent: ViewGroup):
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_list_home, parent, false)){

    private var mTitleView: TextView? = null
    private var mIssn: TextView? = null
    private var mPoints: TextView? = null

    init {
        mTitleView = itemView.findViewById(R.id.tv_home_title)
        mIssn = itemView.findViewById(R.id.tv_home_issn)
        mPoints = itemView.findViewById(R.id.tv_home_points)
    }
    fun bind(magazine : Magazine){
        mTitleView?.text = magazine.title1
        mIssn?.text = magazine.issn
        Log.w(TAG,magazine.points.toString() + "${magazine.points}")
        var sum: Int = 0
        magazine.points.forEach { p -> sum = sum + p.value}
        mPoints?.text = sum.toString()

    }
}