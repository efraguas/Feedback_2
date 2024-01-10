package com.example.feedback_2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feedback_2b.adapter.AdapterBanderas
import com.example.feedback_2b.data.DataSet
import com.example.feedback_2b.databinding.ActivityMainBinding
import com.example.feedback_2b.model.Pais

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    //para trabajar con la lista usamos un ArrayAdapter sera de tipo Pais que es lo que contiene mi lista
    private lateinit var adapterlista : ArrayAdapter<Pais>
    private lateinit var adapadorPais : AdapterBanderas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //adaptador para uso del recycler view le pasamos los dos parametros
        //lista -> companion object del DataSet
        //contexto -> hay que pasarle "this"
        adapadorPais = AdapterBanderas(DataSet.getPaises(),this)
        binding.recyclerPaises.adapter = adapadorPais
        //ademas hay que añadirle un layoutManager
        binding.recyclerPaises.layoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)


        //Los Datos de los paises estan en la clase DataSet


        //se le pasa el contexto, layout, y la lista
        //adapterlista = ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, DataSet.getPaises())

        //vinculo con la parte logica usando listView
        //binding.listaPaises.adapter = adapterlista

        // Cuando se haga pulsacion larga aparezca el nombre del pais en el TextView
        //binding.listaPaises.setOnItemLongClickListener { parent, view, position, id ->
        //    binding.pais.setText("Pais: ${DataSet.getPaises()[position].nombre.toString()}")
        //    true
        //}

        //click corto que pasaria los datos a la SecondActivity mediante un intent
        //binding.listaPaises.setOnItemClickListener { parent, view, position, id ->
        //    val intent = Intent(this,SecondActivity::class.java)
        //    intent.putExtra("pais",DataSet.getPaises()[position])
        //    startActivity(intent)
        //}


    }
}

