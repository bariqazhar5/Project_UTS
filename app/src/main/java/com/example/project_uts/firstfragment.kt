package com.example.project_uts

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.project_uts.con_tempt
import com.example.project_uts.R

class firstfragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        val btnTemp = view.findViewById<ImageButton>(R.id.f_Tempt)
        val btnWeight = view.findViewById<ImageButton>(R.id.f_Weight)
        val btnSpeed = view.findViewById<ImageButton>(R.id.f_Speed)
        val btnVol = view.findViewById<ImageButton>(R.id.f_vol)
        val btntime = view.findViewById<ImageButton>(R.id.f_time)
        val btnarea = view.findViewById<ImageButton>(R.id.f_Area)
        val btndata = view.findViewById<ImageButton>(R.id.f_data)
        val btnbmi = view.findViewById<ImageButton>(R.id.f_bmi)
        val btnpanjang = view.findViewById<ImageButton>(R.id.f_length)


        btnTemp.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_tempt::class.java)
            startActivity(intentTempt)
        }

        btnWeight.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_weight::class.java)
            startActivity(intentTempt)
        }

        btnSpeed.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_speed::class.java)
            startActivity(intentTempt)
        }

        btnVol.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_volume::class.java)
            startActivity(intentTempt)
        }

        btntime.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_time::class.java)
            startActivity(intentTempt)
        }

        btnarea.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_area::class.java)
            startActivity(intentTempt)
        }

        btndata.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_data::class.java)
            startActivity(intentTempt)
        }

        btnbmi.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_bmi::class.java)
            startActivity(intentTempt)
        }

        btnpanjang.setOnClickListener() {
            val intentTempt = Intent(requireActivity(), con_length::class.java)
            startActivity(intentTempt)
        }
        return view

    }
}







