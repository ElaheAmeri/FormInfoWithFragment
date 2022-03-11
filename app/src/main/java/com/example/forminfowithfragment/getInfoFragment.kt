package com.example.forminfowithfragment

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.navigation.fragment.findNavController

class getInfoFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_get_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnRegister=view.findViewById<Button>(R.id.buttonRegister)
        btnRegister.setOnClickListener(){
            register()
            findNavController().navigate(R.id.action_getInfoFragment_to_showInfoFragment)
        }
    }


    fun register(){
        var infoSharedPreferences="info"
        var sharedPreferences =requireActivity().getSharedPreferences(infoSharedPreferences,0)

        var shareEditore : SharedPreferences.Editor = sharedPreferences.edit()
        shareEditore.putString("fullName",view?.findViewById<EditText>(R.id.editTexeFullName)?.text.toString())
        shareEditore.putString("userName",view?.findViewById<EditText>(R.id.editTextUserName)?.text.toString())
        shareEditore.putString("Email",view?.findViewById<EditText>(R.id.editTextEmail)?.text.toString())
        shareEditore.putString("password",view?.findViewById<EditText>(R.id.editTextpassword)?.text.toString())
        shareEditore.putString("ReTypepassword",view?.findViewById<EditText>(R.id.editTextReTypepassWord)?.text.toString())
        if(view?.findViewById<RadioButton>(R.id.radioBtnFmail)?.isChecked==true){
            shareEditore.putString("Gender",view?.findViewById<Button>(R.id.radioBtnFmail)?.text.toString())
        }else if(view?.findViewById<RadioButton>(R.id.radioBtnMail)?.isChecked==true){
            shareEditore.putString("Gender",view?.findViewById<Button>(R.id.radioBtnMail)?.text.toString())
        }
        shareEditore.apply()
        shareEditore.commit()
        Toast.makeText(activity,"Information saved successfully", Toast.LENGTH_SHORT).show()
    }
}