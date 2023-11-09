package com.example.project_uts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class con_diskon : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_con_diskon)
        val input = findViewById<EditText>(R.id.edtinputharga)
        val diskon = findViewById<EditText>(R.id.edtinputdiskon)
        val hasildiskon = findViewById<TextView>(R.id.tvHasilDiskon)
        val btnhasil = findViewById<Button>(R.id.buttondiskon)

        btnhasil.setOnClickListener() {
            var nilai1 = input.text.toString().toDouble()
            var nilai2 = diskon.text.toString().toDouble()
            var persen = 0.0
            var hasil = 0.0

            persen = (nilai2 / 100) * nilai1
            hasil = nilai1 - persen
            hasildiskon.text = hasil.toString()




        }
    }
}