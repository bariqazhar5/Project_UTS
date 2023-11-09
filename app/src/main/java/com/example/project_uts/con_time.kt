package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_time : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var pilihan1 = 0
        var pilihan2 = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_time)
        val sptime1 = findViewById<Spinner>(R.id.SpTime1)
        val sptime2 = findViewById<Spinner>(R.id.SpTime2)
        val inputtime = findViewById<EditText>(R.id.edtinputtime)
        val hasilsuhu = findViewById<TextView>(R.id.tvHasilTime)
        val btnhasil = findViewById<Button>(R.id.buttontime)

        btnhasil.setOnClickListener() {
            var nilai1 = inputtime.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //Year
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to Year
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 * 52.143 //  to week
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 * 365 // to Day
                pilihan1 == 0 && pilihan2 == 3 -> nilai1 * 8760// to Hour
                pilihan1 == 0 && pilihan2 == 4 -> nilai1 * 525600// to minute
                pilihan1 == 0 && pilihan2 == 5 -> nilai1 * 3.154e+7 // to seond

                //Week
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 / 52.143 // to Year
                pilihan1 == 1 && pilihan2 == 1 -> nilai1  //  to week
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 * 7 // to Day
                pilihan1 == 1 && pilihan2 == 3 -> nilai1 * 168// to Hour
                pilihan1 == 1 && pilihan2 == 4 -> nilai1 * 10080 // to minute
                pilihan1 == 1 && pilihan2 == 5 -> nilai1 * 604800// to seond


                //Day
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 / 365// to Year
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 / 7 //  to week
                pilihan1 == 2 && pilihan2 == 2 -> nilai1  // to Day
                pilihan1 == 2 && pilihan2 == 3 -> nilai1 * 24 // to Hour
                pilihan1 == 2 && pilihan2 == 4 -> nilai1 * 1440// to minute
                pilihan1 == 2 && pilihan2 == 5 -> nilai1 * 86400 // to seond

                //Hour
                pilihan1 == 3 && pilihan2 == 0 -> nilai1 / 8760// to Year
                pilihan1 == 3 && pilihan2 == 1 -> nilai1 / 168//  to week
                pilihan1 == 3 && pilihan2 == 2 -> nilai1 / 24 // to Day
                pilihan1 == 3 && pilihan2 == 3 -> nilai1  // to Hour
                pilihan1 == 3 && pilihan2 == 4 -> nilai1 * 60 // to minute
                pilihan1 == 3 && pilihan2 == 5 -> nilai1 * 3600 // to seond

                //Minute
                pilihan1 == 4 && pilihan2 == 0 -> nilai1 / 525600// to Year
                pilihan1 == 4 && pilihan2 == 1 -> nilai1 / 10080 //  to week
                pilihan1 == 4 && pilihan2 == 2 -> nilai1 / 1440 // to Day
                pilihan1 == 4 && pilihan2 == 3 -> nilai1 / 60 // to Hour
                pilihan1 == 4 && pilihan2 == 4 -> nilai1 // to minute
                pilihan1 == 4 && pilihan2 == 5 -> nilai1 * 60// to seond

                //Second
                pilihan1 == 5 && pilihan2 == 0 -> nilai1 / 3.154e+7 // to Year
                pilihan1 == 5 && pilihan2 == 1 -> nilai1 / 604800 //  to week
                pilihan1 == 5 && pilihan2 == 2 -> nilai1 / 86400 // to Day
                pilihan1 == 5 && pilihan2 == 3 -> nilai1 / 3600// to Hour
                pilihan1 == 5 && pilihan2 == 4 -> nilai1 / 60 // to minute
                pilihan1 == 5 && pilihan2 == 5 -> nilai1 // to seond
                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasilsuhu.text = formattedValue
        }



        sptime1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        sptime2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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