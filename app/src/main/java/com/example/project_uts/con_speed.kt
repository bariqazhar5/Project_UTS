package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_speed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_speed)
        val spspeed1 = findViewById<Spinner>(R.id.SpSpeed1)
        val spspeed2 = findViewById<Spinner>(R.id.SpSpeed2)
        val inputspeed = findViewById<EditText>(R.id.edtinputspeed)
        val hasilspeed = findViewById<TextView>(R.id.tvHasilSpeed)
        val btnhasil = findViewById<Button>(R.id.buttonspeed)

        btnhasil.setOnClickListener() {
            var nilai1 = inputspeed.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //kmh
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to Km/h
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 / 1.609 // to Mph
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 / 1.852 //  to knot
                //MPH
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 * 1.609 // mph to kmh
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 // mph to mph
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 / 1.151 // mph to knot
                //knot
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 / 1.151 // knot to kmh
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 / 1.151 // knot to mph
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 / 1.151 // knot to knot

                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilspeed.text = formattedValue
        }



        spspeed1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spspeed2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
