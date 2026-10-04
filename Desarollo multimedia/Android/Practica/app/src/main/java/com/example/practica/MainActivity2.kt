package com.example.practica

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // hago un bundle para recibir los datos
        val bundle = intent.extras!!

        // Imagen 1
        findViewById<ImageView>(R.id.imagen1).setImageBitmap(intent.getParcelableExtra("imagen"))

        // Imagen 2
        val ruta = intent.getStringExtra("path_foto")
        if (!ruta.isNullOrEmpty()) {
            val bitmap = BitmapFactory.decodeFile(ruta)
            findViewById<ImageView>(R.id.imagen2).setImageBitmap(bitmap)
        }

        findViewById<TextView>(R.id.textoSaludo).text = bundle.getString("textico").toString().ifEmpty { "Vacío" }

        findViewById<Button>(R.id.botonVolver).setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}