package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_dollar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_dollar)

        val spdollar1 = findViewById<Spinner>(R.id.SpDollar1)
        val spdollar2 = findViewById<Spinner>(R.id.SpDollar2)
        val input = findViewById<EditText>(R.id.edtinputDollar)
        val hasildollar = findViewById<TextView>(R.id.tvHasilDollar)
        val btnhasil = findViewById<Button>(R.id.buttonDollar)

        btnhasil.setOnClickListener() {
            var nilai1 = input.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //Idr
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to km2
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 / 15650.0// to square m
                //square m
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 15650.0// to km2
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 // to square m


                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasildollar.text = formattedValue
        }



        spdollar1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                pilihan1 = position
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }

        spdollar2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                pilihan2 = position
            }


            override fun onNothingSelected(parent: AdapterView<*>?) {

            }


        }
    }
}
