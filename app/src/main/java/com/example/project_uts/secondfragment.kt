package com.example.project_uts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment

class secondfragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        val btndiskon = view.findViewById<ImageButton>(R.id.f_diskon)
        val btndollar = view.findViewById<ImageButton>(R.id.f_dollar)
        val edittext = view.findViewById<EditText>(R.id.edtpindah)
        val btnpindah = view.findViewById<Button>(R.id.btnpindah)
        val nilaiEditText = edittext.text.toString()



        btndiskon.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_diskon::class.java)
            startActivity(intentTempt)
        }
        btndollar.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_dollar::class.java)
            startActivity(intentTempt)
        }


        btnpindah.setOnClickListener {
            val input = edittext.text.toString()

            val bundle =Bundle()
            bundle.putString("data", input)
            val fragment = thirdfragment()
            fragment.arguments = bundle
            fragmentManager?.beginTransaction()?.replace(R.id.flFragment,fragment)?.commit()






        }




        return view
    }

}
