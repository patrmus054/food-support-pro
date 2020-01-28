package com.example.napomocinzynierom.ui.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.databinding.ItemListFavoriteBinding


class FavoriteAdapter(private val list: MutableList<Magazine>): RecyclerView.Adapter<FavoriteAdapter.FavoriteViewHolder>() {

        companion object{
            val TAG: String = "FavoriteAdapter"
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
            val binding = DataBindingUtil.inflate<ItemListFavoriteBinding>(
                LayoutInflater.from(parent.context),
                R.layout.item_list_favorite, parent, false)

            return FavoriteViewHolder(binding)
        }

        override fun getItemCount(): Int = list.size

        override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
            val magazine: Magazine = list[position]
            holder.bind(magazine, object : MagazineFavoriteListener{
                override fun onMagazineSelected(magazine: Magazine) {
                    Log.w(TAG, magazine.title1 + " " + magazine.points)
                }
            })
        }


        fun setList(newList: List<Magazine>){
            list.clear()
            list.addAll(newList)
            notifyDataSetChanged()
        }


    class FavoriteViewHolder(private val binding: ItemListFavoriteBinding) : RecyclerView.ViewHolder(binding.root) {
        private var mTitleView: TextView? = null
        private var mIssn: TextView? = null
        private var mPoints: TextView? = null

        init {
            mTitleView = itemView.findViewById(R.id.tv_favorite_title)
            mIssn = itemView.findViewById(R.id.tv_favorite_issn)
            mPoints = itemView.findViewById(R.id.tv_favorite_points)
        }

        fun bind(mMagazine: Magazine, magazineListener: MagazineFavoriteListener) {
            with(binding)
            {
                magazineFavorites = mMagazine
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
    interface MagazineFavoriteListener {
        fun onMagazineSelected(mMagazine: Magazine)
    }
}