package com.example.sugarfreeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sugarfreeapp.databinding.ActivityMainBinding
import com.google.firebase.database.FirebaseDatabase


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var database = FirebaseDatabase.getInstance().reference

        binding.btnekle.setOnClickListener {
            var IntentResult = binding.IntentResult.text.toString()
            var eatable= binding.eatable.text.toString()
            var gluten_amount = binding.glutenAmount.text.toString()
            var name = binding.name.text.toString()

            database.child("barcodes").child(IntentResult.toString()).setValue(Urunler(eatable,gluten_amount,name))
        }

    }
}