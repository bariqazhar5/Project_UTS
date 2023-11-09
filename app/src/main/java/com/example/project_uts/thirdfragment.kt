package com.example.project_uts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class thirdfragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_third, container, false)
        val tvhasil = view.findViewById<TextView>(R.id.tvpindah2)
        val args = this.arguments
        val inputdata = args?.get("data")
        tvhasil.text = inputdata.toString()





        return view
    }

}



