package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_volume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var pilihan1 = 0
        var pilihan2 = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_volume)
        val spvol1 = findViewById<Spinner>(R.id.SpVol1)
        val spvol2 = findViewById<Spinner>(R.id.SpVol2)
        val inputvol = findViewById<EditText>(R.id.edtinputvol)
        val hasilvol = findViewById<TextView>(R.id.tvHasilVol)
        val btnhasil = findViewById<Button>(R.id.buttonVolume)

        btnhasil.setOnClickListener() {
            var nilai1 = inputvol.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //Litre to X
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 //To l
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 1000 //To ml
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 / 1000 //To m3

                //Mililiter to X
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 1000 //To l
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 //To ml
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 * 1000000//To m3

                //Cubic meter    to X
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 * 1000 //To l
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 * 1000000//To ml
                pilihan1 == 2 && pilihan2 == 2 -> nilai1 //To m3
                else -> 0.0 // Other unit conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilvol.text = formattedValue
        }

        spvol1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spvol2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
