package edu.itesm.ubereatssim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_lista.*
import java.time.LocalDateTime
import kotlin.random.Random

class ListaActivity : AppCompatActivity() {
    private lateinit var datoAdapter: datoAdapter
    private lateinit var datos: ArrayList<Datos>

    fun initRecylcer() {
        datos = ArrayList<Datos>()
        datoAdapter = datoAdapter(datos)
        recyler.layoutManager = LinearLayoutManager(this)
        recyler.adapter = datoAdapter

        for (i in 0..10){
            val dato1 = LocalDateTime.now()
            val dato2 = Random.nextInt(1,10)
            val dato = Datos(dato1.toString(), dato2)

            datos.add(dato)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        initRecylcer()
    }
}