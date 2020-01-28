package com.example.napomocinzynierom.ui.properties

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.ui.home.HomeFragment.Companion.homeViewModel
import kotlinx.android.synthetic.main.fragment_properties.*

class PropertiesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle? ): View? {
        val root = inflater.inflate(R.layout.fragment_properties, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bt_cancel.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
            }

        })

        bt_submit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val radioGroup = view.findViewById<RadioGroup>(R.id.rg_properties)
                if (radioGroup.checkedRadioButtonId != -1){
                val selectedRadioButton = view.findViewById<RadioButton>(rg_properties.checkedRadioButtonId)
                    val range = selectedRadioButton.text.split("-")
                    Log.w("loool", range[0]+ " " + range[1])
                    homeViewModel.setSearchParams(1, 10,et_search.text.toString(), range[1].toInt(), range[0].toInt())}
                else{
                    homeViewModel.setSearchParams(1, 10, et_search.text.toString(), 140, 0)
                }

            }

        })
    }
}