package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView

class con_data : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        var pilihan1 = 0
        var pilihan2 = 0

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_data)

        val spdata1 = findViewById<Spinner>(R.id.Spdata1)
        val spdata2 = findViewById<Spinner>(R.id.Spdata2)
        val input = findViewById<EditText>(R.id.edtinputdata)
        val hasildata = findViewById<TextView>(R.id.tvHasilData)
        val btnhasil = findViewById<Button>(R.id.buttonData)

        btnhasil.setOnClickListener() {
            var nilai1 = input.text.toString().toDouble()
            var hasil = 0.0

            hasil = when {
                //byte
                pilihan1 == 0 && pilihan2 == 0 -> nilai1 // to byte
                pilihan1 == 0 && pilihan2 == 1 -> nilai1 / 1000 // to kilobyte
                pilihan1 == 0 && pilihan2 == 2 -> nilai1 / 125000 //  to megabyte
                pilihan1 == 0 && pilihan2 == 3 -> nilai1 / 1.25e+8 // to GigaByte
                pilihan1 == 0 && pilihan2 == 4 -> nilai1 / 1.25e+11 // to Terabyte
                pilihan1 == 0 && pilihan2 == 5 -> nilai1 / 1.25e+14 // to PetaByte
                //Kilobytr
                pilihan1 == 1 && pilihan2 == 0 -> nilai1 * 1000 // to byte
                pilihan1 == 1 && pilihan2 == 1 -> nilai1 // to kilobyte
                pilihan1 == 1 && pilihan2 == 2 -> nilai1 / 1000 //  to megabyte
                pilihan1 == 1 && pilihan2 == 3 -> nilai1 / 1e+6 // to GigaByte
                pilihan1 == 1 && pilihan2 == 4 -> nilai1 / 1e+9 // to Terabyte
                pilihan1 == 1 && pilihan2 == 5 -> nilai1 / 1e+12 // to PetaByte
                //Megabyte
                pilihan1 == 2 && pilihan2 == 0 -> nilai1 * 1e+6 // to byte
                pilihan1 == 2 && pilihan2 == 1 -> nilai1 * 1000 // to kilobyte
                pilihan1 == 2 && pilihan2 == 2 -> nilai1  //  to megabyte
                pilihan1 == 2 && pilihan2 == 3 -> nilai1 / 1000 // to GigaByte
                pilihan1 == 2 && pilihan2 == 4 -> nilai1 / 1e+6 // to Terabyte
                pilihan1 == 2 && pilihan2 == 5 -> nilai1 / 1e+9 // to PetaByte
                //Gigabyte
                pilihan1 == 3 && pilihan2 == 0 -> nilai1 * 1e+9 // to byte
                pilihan1 == 3 && pilihan2 == 1 -> nilai1 * 1e+6 // to kilobyte
                pilihan1 == 3 && pilihan2 == 2 -> nilai1 * 1000//  to megabyte
                pilihan1 == 3 && pilihan2 == 3 -> nilai1  // to GigaByte
                pilihan1 == 3 && pilihan2 == 4 -> nilai1 / 1000 // to Terabyte
                pilihan1 == 3 && pilihan2 == 5 -> nilai1 / 1e+6 // to PetaByte
                //Teraabyte
                pilihan1 == 4 && pilihan2 == 0 -> nilai1 * 1e+12 // to byte
                pilihan1 == 4 && pilihan2 == 1 -> nilai1 * 1e+9 // to kilobyte
                pilihan1 == 4 && pilihan2 == 2 -> nilai1 * 1e+6 //  to megabyte
                pilihan1 == 4 && pilihan2 == 3 -> nilai1 * 1000 // to GigaByte
                pilihan1 == 4 && pilihan2 == 4 -> nilai1  // to Terabyte
                pilihan1 == 4 && pilihan2 == 5 -> nilai1 * 1000 // to PetaByte
                //Petabyte
                pilihan1 == 5 && pilihan2 == 0 -> nilai1 * 1e+15 // to byte
                pilihan1 == 5 && pilihan2 == 1 -> nilai1 * 1e+12 // to kilobyte
                pilihan1 == 5 && pilihan2 == 2 -> nilai1 * 1e+9 //  to megabyte
                pilihan1 == 5 && pilihan2 == 3 -> nilai1 * 1e+6 // to GigaByte
                pilihan1 == 5 && pilihan2 == 4 -> nilai1 * 1000 // to Terabyte
                pilihan1 == 5 && pilihan2 == 5 -> nilai1  // to PetaByte

                else -> 0.0 // Other conversions
            }
            val formattedValue = String.format("%.2f", hasil)
            hasildata.text = formattedValue
        }



        spdata1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

        spdata2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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
