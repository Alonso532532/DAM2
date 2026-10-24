package com.example.estudio4

import android.content.Intent
import android.os.Bundle
<<<<<<< HEAD
import android.util.Log
=======
import android.widget.Toast
>>>>>>> 9b8909f9c16d590348be44362615e0bf2d16b832
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio4.databinding.ActivityMainBinding
import kotlin.math.log

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

        var imagen = R.drawable.usuario1

        binding.image1.setOnClickListener {
            binding.imagenPerfil.setImageResource(R.drawable.usuario1)
            var imagen = R.drawable.usuario1
        }
        binding.image2.setOnClickListener {
            binding.imagenPerfil.setImageResource(R.drawable.usuario2)
            var imagen = R.drawable.usuario2
        }
        binding.image3.setOnClickListener {
            binding.imagenPerfil.setImageResource(R.drawable.usuario3)
            var imagen = R.drawable.usuario3
            Toast.makeText(this, "adadasda", Toast.LENGTH_SHORT).show()
        }

        binding.boton.setOnClickListener {
            var intent = Intent(this, DetallesDePerfil::class.java)

            intent.putExtra("nombre", binding.editTextNombre.text.toString())
            intent.putExtra("edad", binding.editTextEdad.text.toString())
            intent.putExtra("texto", binding.editTextTextMultiLine.text.toString())
            intent.putExtra("imagen", imagen)

            startActivity(intent)
        }


<<<<<<< HEAD
=======
    }

    override fun onStop() {
        super.onStop()


>>>>>>> 9b8909f9c16d590348be44362615e0bf2d16b832
    }

    override fun onPause() {
        super.onPause()

        Log.i("Estado", "Pausando app, vaciando campos")

        var imagen = R.drawable.usuario1
        binding.imagenPerfil.setImageResource(R.drawable.usuario1)

        binding.editTextEdad.setText("")
        binding.editTextNombre.setText("")
        binding.editTextTextMultiLine.setText("")
    }
}

