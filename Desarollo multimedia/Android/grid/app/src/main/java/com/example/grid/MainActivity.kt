package com.example.grid

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.drawToBitmap
import com.example.grid.databinding.ActivityMainBinding

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

        binding.post1.setOnClickListener {
            var intent = Intent(this, Pagina2Activity::class.java)

            intent.putExtra("titulo", binding.textoPost1.text)
            intent.putExtra("contenido", binding.contenidoPost1.text)
            intent.putExtra("foto", R.drawable.imagen)

            startActivity(intent)
        }

        binding.post2.setOnClickListener {
            var intent = Intent(this, Pagina2Activity::class.java)

            intent.putExtra("titulo", binding.textoPost2.text)
            intent.putExtra("contenido", binding.contenidoPost2.text)

            startActivity(intent)
        }

        binding.post3.setOnClickListener {
            var intent = Intent(this, Pagina2Activity::class.java)

            intent.putExtra("titulo", binding.textoPost3.text)
            intent.putExtra("contenido", binding.contenidoPost3.text)

            startActivity(intent)
        }

        binding.post4.setOnClickListener {
            var intent = Intent(this, Pagina2Activity::class.java)

            intent.putExtra("titulo", binding.textoPost4.text)
            intent.putExtra("contenido", binding.contenidoPost4.text)

            startActivity(intent)
        }
    }
}