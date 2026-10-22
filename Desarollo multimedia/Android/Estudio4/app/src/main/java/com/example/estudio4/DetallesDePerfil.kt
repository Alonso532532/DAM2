package com.example.estudio4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio4.databinding.ActivityDetallesDePerfilBinding
import com.example.estudio4.databinding.ActivityMainBinding

class DetallesDePerfil : AppCompatActivity() {

    lateinit var binding: ActivityDetallesDePerfilBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityDetallesDePerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras!!

        binding.imageView.setImageResource(bundle.getInt("imagen"))

        binding.textEdad.text = bundle.getString("edad").toString().ifEmpty { "Vacio" }
        binding.textNombre.text = bundle.getString("nombre").toString().ifEmpty { "Vacio" }
        binding.campoDeTexto.text = bundle.getString("texto").toString().ifEmpty { "Vacio" }

    }
}