package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_length : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_length)

        val splength1 = findViewById<Spinner>(R.id.SpLength1)
        val splength2 = findViewById<Spinner>(R.id.Splength2)
        val input = findViewById<EditText>(R.id.edtinputlength)
        val hasillength = findViewById<TextView>(R.id.tvHasil)
        val btnhasil = findViewById<Button>(R.id.buttonLength)

        btnhasil.setOnClickListener() {
            var nilai1 = input.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //km
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to Km
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 1000 // to M
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 * 100000 //  to cm
                pilihan1 == 0 && pilihan2 == 3 -> nilai1 * 1e+6 // to mm
                pilihan1 == 0 && pilihan2 == 4 -> nilai1 / 1.609  // to mile
                pilihan1 == 0 && pilihan2 == 5 -> nilai1 * 39370 // to inch
                //M
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 1000// to Km
                pilihan1 == 1 && pilihan2 == 1 -> nilai1  // to M
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 * 100 //  to cm
                pilihan1 == 1 && pilihan2 == 3 -> nilai1 * 1000  // to mm
                pilihan1 == 1 && pilihan2 == 4 -> nilai1 / 1609  // to mile
                pilihan1 == 1 && pilihan2 == 5 -> nilai1 * 39.37 // to inch
                //Cm
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 / 100000// to Km
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 / 100 // to M
                pilihan1 == 2 && pilihan2 == 2 -> nilai1  //  to cm
                pilihan1 == 2 && pilihan2 == 3 -> nilai1 * 10 // to mm
                pilihan1 == 2 && pilihan2 == 4 -> nilai1 / 160900  // to mile
                pilihan1 == 2 && pilihan2 == 5 -> nilai1  / 2.54 // to inch
                //mm
                pilihan1 == 3 && pilihan2 == 0 -> nilai1  / 1e+6// to Km
                pilihan1 == 3 && pilihan2 == 1 -> nilai1 / 1000 // to M
                pilihan1 == 3 && pilihan2 == 2 -> nilai1 / 10 //  to cm
                pilihan1 == 3 && pilihan2 == 3 -> nilai1   // to mm
                pilihan1 == 3 && pilihan2 == 4 -> nilai1  / 1.609e+6 // to mile
                pilihan1 == 3 && pilihan2 == 5 -> nilai1 / 25.4  // to inch
                //mile
                pilihan1 == 4 && pilihan2 == 0 -> nilai1 * 1.609// to Km
                pilihan1 == 4 && pilihan2 == 1 -> nilai1 * 1609 // to M
                pilihan1 == 4 && pilihan2 == 2 -> nilai1 * 160900 //  to cm
                pilihan1 == 4 && pilihan2 == 3 -> nilai1 * 1.609e+6  // to mm
                pilihan1 == 4 && pilihan2 == 4 -> nilai1   // to mile
                pilihan1 == 4 && pilihan2 == 5 -> nilai1  * 63360 // to inch
                //inch
                pilihan1 == 5 && pilihan2 == 0 -> nilai1 / 39370 // to Km
                pilihan1 == 5 && pilihan2 == 1 -> nilai1 / 39.37 // to M
                pilihan1 == 5 && pilihan2 == 2 -> nilai1 * 2.54 //  to cm
                pilihan1 == 5 && pilihan2 == 3 -> nilai1  * 25.4 // to mm
                pilihan1 == 5 && pilihan2 == 4 -> nilai1 /  63360 // to mile
                pilihan1 == 5 && pilihan2 == 5 -> nilai1   // to inch

                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasillength.text = formattedValue
        }



        splength1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        splength2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

