package com.example.grid

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.grid.databinding.ActivityMainBinding
import com.example.grid.databinding.ActivityPagina2Binding

class Pagina2Activity : AppCompatActivity() {

    lateinit var binding: ActivityPagina2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPagina2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras!!

        binding.txtTitulo.text = bundle.getString("titulo")
        binding.txtContenido.text = bundle.getString("contenido")

        binding.imgPost.setImageResource(bundle.getInt("foto"))

        binding.btnVolver.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}