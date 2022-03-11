package com.example.forminfowithfragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class showInfoFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_show_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnSavee=view.findViewById<Button>(R.id.buttonSave)
        btnSavee.setOnClickListener(){
            showInfo()
        }

    }

    fun showInfo(){
        val infoSharedPreferences="info"
        val sharedPreferences =activity?.getSharedPreferences(infoSharedPreferences,0)
        val fullName= sharedPreferences?.getString("fullName","Full Name")
        val userName= sharedPreferences?.getString("userName","User Name")
        val email= sharedPreferences?.getString("Email","email")
        val password= sharedPreferences?.getString("password","Pass Word")
        val ReTypepassword= sharedPreferences?.getString("ReTypepassword","Sorry, no password entered")
        val gender= sharedPreferences?.getString("Gender","gender")

        view?.findViewById<EditText>(R.id.editTextFullNameShow)?.setText(fullName).toString()

        view?.findViewById<EditText>(R.id.editTextUsernameShow)?.setText(userName).toString()

        view?.findViewById<EditText>(R.id.editTextEmailShow)?.setText(email).toString()
        if (password.toString()==ReTypepassword.toString()){

            view?.findViewById<EditText>(R.id.editTextEmailShow)?.setText(password).toString()
        }else{
            view?.findViewById<EditText>(R.id.editTextEmailShow)?.error="The values entered are not equal"
        }
    }
}