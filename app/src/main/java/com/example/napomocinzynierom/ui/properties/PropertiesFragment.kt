package com.example.napomocinzynierom.ui.properties

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.napomocinzynierom.R

class PropertiesFragment : DialogFragment() {

    private lateinit var propertiesViewModel: PropertiesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        propertiesViewModel =
            ViewModelProviders.of(this).get(PropertiesViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_properties, container, false)
        val textView: TextView = root.findViewById(R.id.text_send)
        propertiesViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}