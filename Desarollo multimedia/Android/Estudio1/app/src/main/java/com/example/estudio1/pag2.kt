package com.example.estudio1

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.estudio1.databinding.ActivityMainBinding
import com.example.estudio1.databinding.ActivityPag2Binding


class pag2 : AppCompatActivity() {

    private lateinit var binding: ActivityPag2Binding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityPag2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras!!

        var apuesta = bundle.getInt("apuesta")

        binding.textView.setText(apuesta.toString())

        var dinero = bundle.getInt("dinero")

        var cual = (Math.random()*2+1).toInt() == 1

        binding.volver.isEnabled = false

        binding.azul.setOnClickListener {
            binding.volver.isEnabled = true
            binding.azul.isEnabled = false
            binding.rojo.isEnabled = false
            if (cual){
                dinero+=apuesta
                binding.main.setBackgroundColor(Color.GREEN)
                binding.volver.setText(R.string.ganar)
            } else {
                dinero-=apuesta
                binding.main.setBackgroundColor(Color.BLACK)
                binding.volver.setText(R.string.perder)
            }
        }

        binding.rojo.setOnClickListener {
            binding.volver.isEnabled = true
            binding.azul.isEnabled = false
            binding.rojo.isEnabled = false
            if (!cual){
                dinero+=apuesta
                binding.main.setBackgroundColor(Color.GREEN)
                binding.volver.setText(R.string.ganar)
            } else {
                dinero-=apuesta
                binding.main.setBackgroundColor(Color.BLACK)
                binding.volver.setText(R.string.perder)
            }
        }

        binding.volver.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)

            intent.putExtra("ronda", bundle.getInt("ronda").toInt()+1)
            intent.putExtra("record", bundle.getInt("record"))
            intent.putExtra("dinero", dinero)

            startActivity(intent)
        }
    }
}