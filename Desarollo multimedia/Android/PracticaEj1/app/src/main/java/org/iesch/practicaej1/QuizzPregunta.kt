package org.iesch.practicaej1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.iesch.practicaej1.databinding.ActivityHomeBinding
import org.iesch.practicaej1.databinding.ActivityQuizzPreguntaBinding

private lateinit var binding: ActivityQuizzPreguntaBinding

class QuizzPregunta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityQuizzPreguntaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras!!

        var pregunta = bundle.getInt("pagina")

        var primera = true;

        findViewById<Button>(R.id.botonSiguiente2).setOnClickListener {
            if (findViewById<RadioButton>(R.id.Resp2).isChecked || findViewById<RadioButton>(R.id.Resp1).isChecked) {
                var intent = Intent(this, QuizzRespuesta::class.java)

                intent.putExtra("ok", findViewById<RadioButton>(R.id.Resp1).isChecked == primera)
                intent.putExtra("pagina", ++pregunta)

                startActivity(intent)
            } else {
                Toast.makeText(this, R.string.errorToast, Toast.LENGTH_SHORT).show()
            }
        }

        when (pregunta) {
            1 -> {
                binding.TextoProgreso.setText("1/3")
                binding.BarraDeProgreso.setProgress(33)

                binding.TextoPregunta.setText(R.string.Pregunta1)
                binding.ValorPregunta.setText(R.string.textoPregunta1)

                binding.Resp1.setText(R.string.op11)
                binding.Resp2.setText(R.string.op12)

                primera = false
            }
            2 -> {
                binding.TextoProgreso.setText("2/3")
                binding.BarraDeProgreso.setProgress(66)

                binding.TextoPregunta.setText(R.string.Pregunta2)
                binding.ValorPregunta.setText(R.string.textoPregunta2)

                binding.Resp1.setText(R.string.op22)
                binding.Resp2.setText(R.string.op21)
            }
            3 -> {
                binding.TextoProgreso.setText("3/3")
                binding.BarraDeProgreso.setProgress(100)

                binding.TextoPregunta.setText(R.string.Pregunta3)
                binding.ValorPregunta.setText(R.string.textoPregunta3)

                binding.Resp1.setText(R.string.op31)
                binding.Resp2.setText(R.string.op32)

                primera = false
            }
        }

    }
}