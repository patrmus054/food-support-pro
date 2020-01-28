package com.example.napomocinzynierom

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Message
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.napomocinzynierom.data.remote.Magazine
import com.example.napomocinzynierom.data.remote.RemoteDataSource
import com.example.napomocinzynierom.ui.favorite.FavoriteFragment
import com.example.napomocinzynierom.ui.home.HomeFragment.Companion.homeViewModel
import com.example.napomocinzynierom.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_specific.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SecificsActivity: AppCompatActivity() {

    lateinit var message: String
    lateinit var result: Magazine
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_specific)

        Log.w("SpecificActivity", homeViewModel.getMagazineId())


        var viewModelJob = Job()
        val corountineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
        corountineScope.launch {
            result = RemoteDataSource().getMagazineById(homeViewModel.getMagazineId()!!)
            tv_spec_categories.text = tv_spec_categories.text.toString() + result.data.toString()
            tv_spec_id.text = tv_spec_id.text.toString() + result.id.toString()
            tv_spec_title1.text = tv_spec_title1.text.toString() + result.title1.toString()
            tv_spec_title2.text = tv_spec_title2.text.toString() + result.title2.toString()
            tv_spec_issn.text = tv_spec_issn.text.toString() + result.issn.toString()
            tv_spec_issn2.text = tv_spec_issn2.text.toString() + result.issn2.toString()
            tv_spec_e_issn.text = tv_spec_e_issn.text.toString() + result.eIssn.toString()
            tv_spec_e_issn2.text = tv_spec_e_issn2.text.toString() + result.eIssn2.toString()

            var temp =  String()
            result.points.forEach{
                temp + it.id + ""
            }
            tv_spec_points_id.text = tv_spec_points_id.text.toString() +  temp


            temp = ""
            result.points.forEach{ temp + it.yaar + ""}
            tv_spec_points_year.text = tv_spec_points_year.text.toString() + temp

            var temp2: Int = 0
            result.points.forEach{temp2 += it.value}
            tv_spec_points_value.text = tv_spec_points_value.text.toString() + temp2

            tv_spec_points_v.text = tv_spec_points_v.text.toString() + result.v.toString()

        }

        bt_favorites.setOnClickListener{
            corountineScope.launch {
                var lol = RemoteDataSource().addMagazine(LoginActivity.userID!!, result.id!!)
                Log.w("lol", lol.message)
                message = lol.message!!

            }
        }
//        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}