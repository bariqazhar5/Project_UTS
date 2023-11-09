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

class con_weight : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_weight)
        val spweight1 = findViewById<Spinner>(R.id.SpWeight1)
        val spweight2 = findViewById<Spinner>(R.id.SpWeight2)
        val inputweight = findViewById<EditText>(R.id.edtinputweight)
        val hasilweight = findViewById<TextView>(R.id.tvHasilWeight)
        val btnhasil = findViewById<Button>(R.id.buttonWeight)

        btnhasil.setOnClickListener() {
            var nilai1 = inputweight.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //KG to X
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 //To Kg
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 1000 //To g
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 * 1_000_000 //To mg
                pilihan1 == 0 && pilihan2 == 3 -> nilai1 / 1000 //To T
                pilihan1 == 0 && pilihan2 == 4 -> nilai1 * 2.205 //To lb
                //Gram to X
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 1000 //To Kg
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 //To g
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 * 1000//To mg
                pilihan1 == 1 && pilihan2 == 3 -> nilai1 / 100000 //To T
                pilihan1 == 1 && pilihan2 == 4 -> nilai1 / 453.6 //To lb
                //Milligram to X
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 /  1_000_000 //To Kg
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 / 1000//To g
                pilihan1 == 2 && pilihan2 == 2 -> nilai1 //To mg
                pilihan1 == 2 && pilihan2 == 3 -> nilai1 / 1_000_000_000.0 //To T
                pilihan1 == 2 && pilihan2 == 4 -> nilai1 / 453600 //To lb
                //Tonne to X
                pilihan1 == 3 && pilihan2 == 0 -> nilai1 * 1000 //To Kg
                pilihan1 == 3 && pilihan2 == 1 -> nilai1 * 1000000//To g
                pilihan1 == 3 && pilihan2 == 2 -> nilai1 * 1_000_000_000//To mg
                pilihan1 == 3 && pilihan2 == 3 -> nilai1 //To T
                pilihan1 == 3 && pilihan2 == 4 -> nilai1 * 2205.6 //To lb
                //Pound to X
                pilihan1 == 4 && pilihan2 == 0 -> nilai1 / 2.205 //To Kg
                pilihan1 == 4 && pilihan2 == 1 -> nilai1 * 453.6//To g
                pilihan1 == 4 && pilihan2 == 2 -> nilai1 * 453600//To mg
                pilihan1 == 4 && pilihan2 == 3 -> nilai1 * 0.00045359237  //To T
                pilihan1 == 4 && pilihan2 == 4 -> nilai1//To lb
                else -> 0.0 // Other unit conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilweight.text = formattedValue
        }

        spweight1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spweight2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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