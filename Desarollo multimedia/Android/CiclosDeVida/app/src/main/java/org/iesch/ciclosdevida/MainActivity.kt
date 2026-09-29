package org.iesch.ciclosdevida

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.i("CICLOVIDA", "Entramos en el método on create")

        findViewById<Button>(R.id.irAOtraActivity).setOnClickListener {
            startActivity(Intent(this, OtraActivity::class.java))
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("CICLOVIDA", "Entramos en el método on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("CICLOVIDA", "Entramos en el método on resume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("CICLOVIDA", "Entramos en el método on restart")
    }

    override fun onPause() {
        super.onPause()

        Log.i("CICLOVIDA", "Entramos en el método on pause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("CICLOVIDA", "Entramos en el método on stop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("CICLOVIDA", "Entramos en el método on destroy")
    }
}