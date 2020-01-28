package com.example.napomocinzynierom.ui.register

import android.content.Intent
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.example.napomocinzynierom.R
import com.example.napomocinzynierom.Repository
import com.example.napomocinzynierom.data.remote.RemoteDataSource
import com.example.napomocinzynierom.ui.login.LoginActivity
import kotlinx.android.synthetic.main.register_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {

    companion object : () -> Fragment {
        fun newInstance() = RegisterFragment()
        override fun invoke(): Fragment {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }

    private var viewModelJob = Job()
    private val corountineScope = CoroutineScope(viewModelJob + Dispatchers.Main)
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.register_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel::class.java)
        bt_new_user_register.setOnClickListener{
            if(simpleValidation())
            {
                corountineScope.launch {
                    RemoteDataSource().addUser(et_new_user_login.text.toString(), et_new_user_password.text.toString(),
                        et_new_user_first_name.text.toString(), et_new_user_last_name.text.toString())
                }
                Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                startActivity(Intent(activity, LoginActivity::class.java))
            }else{
                Toast.makeText(activity, "Invalid data", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun simpleValidation(): Boolean{
        return if (et_new_user_last_name.text.isEmpty() ||
            et_new_user_first_name.text.isEmpty() ||
            et_new_user_password.text.length < 5 ||
            et_new_user_login.text.isEmpty()
        ) false else return true
    }


}
