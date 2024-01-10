package com.example.feedback_2b

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.feedback_2b.databinding.CheckboxActivityBinding
import com.example.feedback_2b.model.Pais

@SuppressLint("StaticFieldLeak")
private lateinit var binding: CheckboxActivityBinding
private lateinit var pais : Pais

class CheckboxActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CheckboxActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //recuperar datos del pais y poblacion
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            pais = intent.extras!!.getSerializable("pais", Pais::class.java)!!
        } else
            pais = intent.extras!!.getSerializable("pais") as Pais

        binding.paises.setOnCheckedChangeListener { paises, checkedId ->
            if(checkedId.equals(pais)){
                Glide.with(applicationContext)
                    .load(pais.Imagen)
                    .placeholder(R.drawable.defecto)
                    .into(binding.imagen)
            }

            binding.atras.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}