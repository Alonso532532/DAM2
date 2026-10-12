package org.iesch.practicaej1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.net.URI
import androidx.core.net.toUri

class QuizzRespuesta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quizz_respuesta)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var bundle = intent.extras!!

        findViewById<Button>(R.id.botonSiguiente).setOnClickListener {
            var intent = Intent(this, QuizzPregunta::class.java)
            if (bundle.getInt("pagina")<4) {
                intent.putExtra("pagina", bundle.getInt("pagina"))
            } else {
                intent.putExtra("pagina", 1)
            }
            startActivity(intent)
        }

        if (bundle.getInt("pagina")>3) {
            findViewById<Button>(R.id.botonSiguiente).setText(R.string.botonRepetir)
        }

        if (bundle.getBoolean("ok")){
            findViewById<ImageView>(R.id.imageViewQuizz).setImageResource(R.drawable.tick)

            findViewById<TextView>(R.id.textoGrande).setText(R.string.aciertoGrande)
            findViewById<TextView>(R.id.textoPequeño).setText(R.string.aciertoPequeno)
        } else {
            findViewById<ImageView>(R.id.imageViewQuizz).setImageResource(R.drawable.equis)

            findViewById<TextView>(R.id.textoGrande).setText(R.string.errorGrande)
            findViewById<TextView>(R.id.textoPequeño).setText(R.string.errorPequeno)
        }
    }
}