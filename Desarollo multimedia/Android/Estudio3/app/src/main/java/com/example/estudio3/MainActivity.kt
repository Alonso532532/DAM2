package com.example.estudio3

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio3.databinding.ActivityMain2Binding
import com.example.estudio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var texto = binding.texto1.text.toString()
        var color = binding.cartaColor1.cardBackgroundColor.defaultColor
        var imagen = R.drawable.blindaje

        binding.cartaTexto1.setOnClickListener {
            texto = binding.texto1.text.toString()
        }

        binding.cartaTexto2.setOnClickListener {
            texto = binding.texto2.text.toString()
        }

        binding.cartaTexto3.setOnClickListener {
            texto = binding.texto3.text.toString()
        }

        binding.cartaColor1.setOnClickListener {
            color = binding.cartaColor1.cardBackgroundColor.defaultColor
        }

        binding.cartaColor2.setOnClickListener {
            color = binding.cartaColor2.cardBackgroundColor.defaultColor
        }

        binding.cartaColor3.setOnClickListener {
            color = binding.cartaColor3.cardBackgroundColor.defaultColor
        }

        binding.imagen1.setOnClickListener {
            imagen = R.drawable.blindaje
        }

        binding.imagen2.setOnClickListener {
            imagen = R.drawable.contrasena
        }

        binding.imagen3.setOnClickListener {
            imagen = R.drawable.senal
        }

        binding.button.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("texto", texto)
            intent.putExtra("color", color)
            intent.putExtra("imagen", imagen)

            startActivity(intent)
        }
    }
}