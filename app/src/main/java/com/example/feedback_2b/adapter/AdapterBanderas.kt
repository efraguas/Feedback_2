package com.example.feedback_2b.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.feedback_2b.R
import com.example.feedback_2b.model.Pais
import com.bumptech.glide.Glide
import com.example.feedback_2b.CheckboxActivity
import com.example.feedback_2b.SecondActivity
import com.example.feedback_2b.data.DataSet
import com.google.android.material.snackbar.Snackbar


class AdapterBanderas(var lista: ArrayList<Pais>, var contexto: Context): RecyclerView.Adapter<AdapterBanderas.Pais_holder>() {


    //patron de la lista
    class Pais_holder(vista:View):RecyclerView.ViewHolder(vista){
        //extraer cada elemento del patron de la lista -> imagen, texto

        var imagen_fila: ImageView
        var texto_fila: TextView
            init{
                //inicializar las variables
                imagen_fila = vista.findViewById(R.id.imagen_fila)
                texto_fila = vista.findViewById(R.id.nombre_fila)
            }



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Pais_holder {
        //como se crea el patron

        val vista: View = LayoutInflater.from(contexto).inflate(R.layout.item_banderas,parent,false)

        return Pais_holder(vista)
    }

    override fun getItemCount(): Int {
        //numero de elementos que tendra que adaptar
        return lista.size
    }

    override fun onBindViewHolder(holder: Pais_holder, position: Int) {
        //representa cada elememto de la lista en su posicion (utilizando el patron)
        val item = lista[position]
        holder.texto_fila.text = item.nombre
        Glide.with(contexto).load(item.Imagen).into(holder.imagen_fila)

        //desde aqui se gestionan las pulsaciones en un recyclerView


        //click corto que pasaria los datos a la SecondActivity mediante un intent

        holder.texto_fila.setOnClickListener {
            val intent = Intent(contexto, SecondActivity::class.java)
            intent.putExtra("pais", DataSet.getPaises()[position])
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }

        holder.imagen_fila.setOnClickListener {
            val intent = Intent(contexto, CheckboxActivity::class.java)
            intent.putExtra("pais", DataSet.getPaises()[position])
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            contexto.startActivity(intent)
        }

        holder.imagen_fila.setOnLongClickListener {
            Snackbar.make(holder.imagen_fila,"Pais: ${DataSet.getPaises()[position].nombre.toString()}",Snackbar.LENGTH_SHORT).show()
            true
        }




    }
}