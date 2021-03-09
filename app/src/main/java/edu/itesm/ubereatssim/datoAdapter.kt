package edu.itesm.ubereatssim

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class datoAdapter(private val listaDatos: List<Datos>) : RecyclerView.Adapter<datoAdapter.DatoViewHolder>() {
    inner class DatoViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var dato1 = v.findViewById<TextView>(R.id.dato1)
        var dato2 = v.findViewById<TextView>(R.id.dato2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DatoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dato_linea = inflater.inflate(R.layout.renglon_layout, parent, false)
        return DatoViewHolder(dato_linea)
    }

    override fun onBindViewHolder(holder: DatoViewHolder, position: Int) {
        val dato = listaDatos[position]
        val dato1 = dato.dato1
        val dato2 = dato.dato2

        holder.dato1.text = dato1
        holder.dato2.text = "$dato2"
    }

    override fun getItemCount(): Int {
        return listaDatos.size
    }
}