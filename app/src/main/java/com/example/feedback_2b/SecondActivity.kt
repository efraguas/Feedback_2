package com.example.feedback_2b

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.feedback_2b.databinding.SecondActivityBinding
import com.example.feedback_2b.model.Pais
import android.content.Intent

class SecondActivity : AppCompatActivity() {

    private lateinit var binding : SecondActivityBinding
    private lateinit var pais : Pais

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar datos del pais y poblacion
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pais = intent.extras!!.getSerializable("pais", Pais::class.java)!!
        } else
            pais = intent.extras!!.getSerializable("pais") as Pais


        //de manera opcional y por estetica incluire la bandera del pais y una generica
        // usaremos glide en esta aplicacion

        Glide.with(applicationContext)
            .load(pais.Imagen)
            .placeholder(R.drawable.defecto)
            .into(binding.bandera)

        binding.nombre.text = "Pais: ${pais.nombre}"
        binding.poblacion.text = " Poblacion: ${pais.poblacion}M de personas"

        binding.atras.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}