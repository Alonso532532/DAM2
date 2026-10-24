package com.example.estudio5

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio5.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonAplicar.setOnClickListener {

            var pos = binding.editTextPos.text.toString()

            if(pos == "1"){
                binding.textE1.setText(binding.editTextTextTexto.text.toString())
            } else if(pos == "2"){
                binding.textE2.setText(binding.editTextTextTexto.text.toString())
            } else if(pos == "3"){
                binding.textE3.setText(binding.editTextTextTexto.text.toString())
            } else if(pos == "4"){
                binding.textE4.setText(binding.editTextTextTexto.text.toString())
            } else if(pos == "5"){
                binding.textE5.setText(binding.editTextTextTexto.text.toString())
            } else {
                Toast.makeText(this, "Posición no encontrada", Toast.LENGTH_SHORT).show()
            }
        }


    }
}