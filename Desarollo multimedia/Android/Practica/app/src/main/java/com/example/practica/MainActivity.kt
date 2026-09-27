package com.example.practica

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practica.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    // Aquí para poder usarlo en otros métodos
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Creo el binding Importante que sea aquí arriba y que el "setContentView(binding.root)" reemplace
        // el "setContentView(R.layout.activity_main)"
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        binding.calcularSuma.setOnClickListener {
            val sum1 = binding.campoSuma1.text.toString().toIntOrNull() ?: 0
            val sum2 = binding.campoSuma2.text.toString().toIntOrNull() ?: 0
            binding.resultadoSuma.text = (sum1+sum2).toString()
            calcularTotal()
        }

        binding.calcularMult.setOnClickListener {
            val mult1 = binding.campoMulti1.text.toString().toIntOrNull() ?: 0
            val mult2 = binding.campoMulti2.text.toString().toIntOrNull() ?: 0
            binding.resultadoMulti.text = (mult1*mult2).toString()
            calcularTotal()
        }

        binding.moverse.setOnClickListener {
            var intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("textico", binding.resultadoTotal.text)

            startActivity(intent)
        }

    }

    fun calcularTotal(){
        binding.resultadoTotal.text = getString(R.string.resultado, (binding.resultadoSuma.text.toString().toIntOrNull() ?: 0) + (binding.resultadoMulti.text.toString().toIntOrNull() ?: 0))
    }
}