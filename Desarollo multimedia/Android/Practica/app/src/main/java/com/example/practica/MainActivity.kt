package com.example.practica

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Environment
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.drawToBitmap
import com.example.practica.databinding.ActivityMainBinding
import java.io.File


class MainActivity : AppCompatActivity() {
    // Aquí para poder usarlo en otros métodos
    private lateinit var binding: ActivityMainBinding

    // Imágenes 2
    // Ruta del archivo donde se guardará la foto
    private var picturePath = ""

    // El resultado es un Boolean: true si se ha echo foto
    private val getContent = registerForActivityResult(ActivityResultContracts.TakePicture()) { success ->
        if (success && picturePath.isNotEmpty()) {
            val bitmap = BitmapFactory.decodeFile(picturePath)
            binding.imagen2.setImageBitmap(bitmap)
        }
    }

    // Creo el archivo que v a ser un .jpg y le asigno un directorio que será el del file_paths
    private fun crearImagenFile(): File {
        val directorio = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val archivo = File.createTempFile("foto", ".jpg", directorio)
        picturePath = archivo.absolutePath   // guardo la ruta
        return archivo
    }


    private fun abrirCamara() {
        val imageFile = crearImagenFile()
        val uri = FileProvider.getUriForFile(
            this,
            "${applicationContext.packageName}.provider",
            imageFile
        )
        getContent.launch(uri)   // aquí se le pasa la Uri, no null
    }

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

        // Imágenes v1
        var fotoBitmap: Bitmap? = null

        val getContent = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            if (bitmap != null) {
                fotoBitmap = bitmap
                binding.imagen1.setImageBitmap(bitmap)
            }
        }

        binding.imagen1.setOnClickListener {
            getContent.launch(null)
        }

        // Imágenes v2
        binding.imagen2.setOnClickListener {
            abrirCamara()
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

            intent.putExtra("textico", binding.resultadoTotal.text.toString())

            intent.putExtra("imagen", fotoBitmap)

            intent.putExtra("path_foto", picturePath)

            startActivity(intent)
        }

    }

    fun calcularTotal(){
        binding.resultadoTotal.text = getString(R.string.resultado, (binding.resultadoSuma.text.toString().toIntOrNull() ?: 0) + (binding.resultadoMulti.text.toString().toIntOrNull() ?: 0))
    }
}