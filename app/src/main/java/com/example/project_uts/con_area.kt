package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class con_area : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_area)

        val sparea1 = findViewById<Spinner>(R.id.Sparea1)
        val sparea2 = findViewById<Spinner>(R.id.Sparea2)
        val input = findViewById<EditText>(R.id.edtinputarea)
        val hasilarea = findViewById<TextView>(R.id.tvHasilArea)
        val btnhasil = findViewById<Button>(R.id.buttonarea)

        btnhasil.setOnClickListener() {
            var nilai1 = input.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //square km
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to km2
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 1e+6 // to square m
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 * 247.1 //  to acre
                pilihan1 == 0 && pilihan2 == 3 -> nilai1 * 100 // to hectare
                //square m
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 1e+6// to km2
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 // to square m
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 / 4047//  to acre
                pilihan1 == 1 && pilihan2 == 3 -> nilai1 / 10000// to hectare
                //acre
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 / 247.1 // to km2
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 * 4047// to square m
                pilihan1 == 2 && pilihan2 == 2 -> nilai1  //  to acre
                pilihan1 == 2 && pilihan2 == 3 -> nilai1 / 2.471 // to hectare
                //Hectare
                pilihan1 == 3 && pilihan2 == 0 -> nilai1 / 100// to km2
                pilihan1 == 3 && pilihan2 == 1 -> nilai1 * 10000// to square m
                pilihan1 == 3 && pilihan2 == 2 -> nilai1 * 2.471 //  to acre
                pilihan1 == 3 && pilihan2 == 3 -> nilai1 // to hectare

                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilarea.text = formattedValue
        }



        sparea1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        sparea2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
