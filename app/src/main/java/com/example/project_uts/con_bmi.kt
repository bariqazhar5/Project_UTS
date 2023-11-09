package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class con_bmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_bmi)

        val btnhasil = findViewById<Button>(R.id.buttonbmi)

        btnhasil.setOnClickListener {
            hitungBMI()
        }
    }

    private fun hitungBMI() {
        val inputweight = findViewById<EditText>(R.id.edtinputberat)
        val inputheight = findViewById<EditText>(R.id.edtinputtinggi)
        val hasilbmi = findViewById<TextView>(R.id.tvHasilbmi)

        val berat = inputweight.text.toString().toDoubleOrNull()
        val tinggi = inputheight.text.toString().toDoubleOrNull()

        if (berat != null && tinggi != null && tinggi != 0.0) {
            val bmi = berat / (tinggi * tinggi)
            tampilkanHasilBMI(bmi)
        } else {
            hasilbmi.text = "Masukkan berat dan tinggi yang valid"
        }
    }

    private fun tampilkanHasilBMI(bmi: Double) {
        val hasilbmi = findViewById<TextView>(R.id.tvHasilbmi)
        val bmiString = String.format("BMI Anda: %.2f\n%s", bmi, interpretasiBMI(bmi))
        hasilbmi.text = bmiString
    }

    private fun interpretasiBMI(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Kategori: Kekurangan Berat Badan"
            bmi < 25 -> "Kategori: Normal"
            bmi < 30 -> "Kategori: Kelebihan Berat Badan"
            else -> "Kategori: Obesitas"
        }
    }
}