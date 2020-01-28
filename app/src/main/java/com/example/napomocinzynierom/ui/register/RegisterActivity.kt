package com.example.napomocinzynierom.ui.register

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.addFragment

class RegisterActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        addFragment(R.id.register_content_frame, ::RegisterFragment)

    }
}