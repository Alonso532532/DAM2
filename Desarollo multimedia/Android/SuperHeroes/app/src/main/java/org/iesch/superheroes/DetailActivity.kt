package org.iesch.superheroes

import android.os.Bundle
import android.widget.RatingBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.superheroes.databinding.ActivityDetailBinding
import org.iesch.superheroes.databinding.ActivityMainBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityDetailBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Recivo los datos enviados con el intent
        val bundle = intent.extras!!
        val nombreSuperHeroe = bundle.getString("nombreSuperHeroe") ?: "No Hay nombre" // Esto es un elvis, es el texto que sale en caso de que esté vacío, un alt, pero no va porque no se manda null
        val alterego = bundle.getString("alterego") ?: "No Hay alterego"
        val bio = bundle.getString("bio") ?: "No Hay bio"
        val power = bundle.getFloat("power")

        // Ahora hay que rellenar los campos
        binding.heroNameTv.text = nombreSuperHeroe
        binding.alterEgoResult.text = alterego
        binding.Bioesult.text = bio

        binding.ratingBar2.rating = power

    }
}