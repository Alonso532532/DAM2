package com.example.estudio1

import android.content.Intent
import android.os.Bundle
import android.view.DragEvent
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

        var bundle = intent.extras

        var ronda = bundle?.getInt("ronda") ?: 1
        var record = bundle?.getInt("record") ?: 100
        var dinero = bundle?.getInt("dinero") ?: 100

        if (record < dinero) record=dinero

        binding.textoDinero.setText(dinero.toString()+"€")
        binding.textoRonda.setText(getString(R.string.ronda,ronda))
        binding.textoMax.setText(getString(R.string.max, record))

        binding.botonApostar.setOnClickListener {
            if (binding.seekBar.progress == 0){
                Toast.makeText(this, "No puedes apostar 0", Toast.LENGTH_SHORT).show()
            } else {
                var intent = Intent(this, pag2::class.java)

                intent.putExtra("apuesta", ((binding.seekBar.progress.toDouble()/100)*dinero).toInt())
                intent.putExtra("ronda", ronda)
                intent.putExtra("record", record)
                intent.putExtra("dinero", dinero)

                startActivity(intent)
            }
        }

        binding.botonReiniciar.setOnClickListener {
            ronda =  1
            record = 100
            dinero = 100

            binding.textoDinero.setText(dinero.toString()+"€")
            binding.textoRonda.setText(getString(R.string.ronda,ronda))
            binding.textoMax.setText(getString(R.string.max, record))
        }

    }
}
