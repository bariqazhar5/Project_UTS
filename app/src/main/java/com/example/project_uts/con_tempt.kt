package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener


class con_tempt : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var pilihan1 = 0
        var pilihan2 = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_tempt)
        val spsuhu1 = findViewById<Spinner>(R.id.SpSuhu1)
        val spsuhu2 = findViewById<Spinner>(R.id.SpSuhu2)
        val inputsuhu = findViewById<EditText>(R.id.edtinputsuhu)
        val hasilsuhu = findViewById<TextView>(R.id.tvHasilSuhu)
        val btnhasil = findViewById<Button>(R.id.buttonsuhu)



        btnhasil.setOnClickListener() {
            var nilai1 = inputsuhu.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // Celcius to Celcius
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 9 / 5 + 32 // Celcius to Fahrenheit
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 + 273.15 // Celcius to Kelvin
                pilihan1 == 1 && pilihan2 == 0 -> (nilai1 - 32) * 5 / 9 // Fahrenheit to Celcius
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 // Fahrenheit to Fahrenheit
                pilihan1 == 1 && pilihan2 == 2 -> (nilai1 - 32) * 5 / 9 + 273.15 // Fahrenheit to Kelvin
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 - 273.15// kelvin to celcius
                pilihan1 == 2 && pilihan2 == 1 -> (nilai1 - 273.15) * 9 / 5 + 32 // kelvin to fahrenhiet
                pilihan1 == 2 && pilihan2 == 2 -> nilai1 // kelvin to kelvin
                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilsuhu.text = formattedValue
            }



        spsuhu1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spsuhu2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

