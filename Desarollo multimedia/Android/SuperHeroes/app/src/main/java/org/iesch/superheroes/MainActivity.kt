package org.iesch.superheroes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityMainBinding
import org.iesch.superheroes.model.Superheroe

class MainActivity : AppCompatActivity() {

    // 1 - Creo la variable lateinit para inicializarla luego
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 2 - inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)

        // 3 - Usi el binding para inflar la vista
        setContentView(binding.root)

        binding.Guardar

        // A partir de aquí tomo contról de los elementos del programa

        val botonGuardar = binding.Guardar

        // Añado un trigger para el boton
        botonGuardar.setOnClickListener {
            // Obtengo los valores al hacer click
            // El .toString es para asegurar que sean strings
            val nombreSuperHeroe = binding.heroNameEdit.text.toString()
            val alterego = binding.alterEgoEdit.text.toString()
            val bio = binding.editTextText.text.toString()
            val power = binding.power.rating
            irADetailActivity(Superheroe(nombreSuperHeroe, alterego, bio, power))
        }
    }

    fun irADetailActivity(superheroe: Superheroe) {
        // Creo el intent que me va a permitir moverme entre actividades
        val intent = Intent(this, DetailActivity::class.java)

        // Añado todos los campos al intent para mandarlos al DetailActivity
        //intent.putExtra("nombreSuperHeroe", nombreSuperHeroe)
        //intent.putExtra("alterego", alterego)
        //intent.putExtra("bio", bio)
        //intent.putExtra("power", power)

        intent.putExtra("superHeroe", superheroe)

        // La ejecuto
        startActivity(intent)
    }
}