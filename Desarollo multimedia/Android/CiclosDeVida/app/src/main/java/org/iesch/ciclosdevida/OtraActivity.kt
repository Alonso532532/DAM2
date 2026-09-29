package org.iesch.ciclosdevida

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OtraActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_otra)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.w("CICLOVIDA", "Entramos en el método on create")

        findViewById<Button>(R.id.volver).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        Log.w("CICLOVIDA", "Entramos en el método on start")
    }

    override fun onResume() {
        super.onResume()

        Log.w("CICLOVIDA", "Entramos en el método on resume")
    }

    override fun onRestart() {
        super.onRestart()

        Log.w("CICLOVIDA", "Entramos en el método on restart")
    }

    override fun onPause() {
        super.onPause()

        Log.w("CICLOVIDA", "Entramos en el método on pause")
    }

    override fun onStop() {
        super.onStop()

        Log.w("CICLOVIDA", "Entramos en el método on stop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.w("CICLOVIDA", "Entramos en el método on destroy")
    }
}