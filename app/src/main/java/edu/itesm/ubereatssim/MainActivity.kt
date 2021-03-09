package edu.itesm.ubereatssim

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var subtotalVal = 0.0
    var smallOrderVal = 0.0
    var serviceFeeVal = 0.0
    var deliveryFeeVal = 0.0
    var tipVal = 0.1
    var finalPrice = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){

        //Adds listener to editSubtotal textField
        editSubtotal.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //Log.i("edu.itesm.ubereatssim", "The text is changing yo.")
                try {
                    subtotalVal = s.toString().toDouble()
                    //Math.round se está usando para mejorar el formateo en la pantalla final a dos decimales.
                    smallOrderVal = Math.round(s.toString().toDouble() * 0.02 * 100).toDouble() / 100
                    editSmallOrder.text = "$" + smallOrderVal.toString()
                    serviceFeeVal = Math.round(s.toString().toDouble() * 0.05 * 100).toDouble() / 100
                    editServiceFee.text = "$" + serviceFeeVal.toString()
                    deliveryFeeVal = Math.round(s.toString().toDouble() * 0.1 * 100).toDouble() / 100
                    editDeliveryFee.text = "$" + deliveryFeeVal.toString()
                    calculateTotal()
                }
                catch (e: Exception){
                    subtotalVal = 0.0
                    smallOrderVal = 0.0
                    editSmallOrder.text = "$" + smallOrderVal.toString()
                    serviceFeeVal = 0.0
                    editServiceFee.text = "$" + serviceFeeVal.toString()
                    deliveryFeeVal = 0.0
                    editDeliveryFee.text = "$" + deliveryFeeVal.toString()
                    calculateTotal()
                    Log.i("edu.itesm.uberreatssim",
                        "Error, subtotal can't be empty. Details:\n$e"
                    )
                }
            }
        })

        //Adds listener to radio buttons behaviour
        radio10.setOnClickListener(){
            tipVal = 0.1
            calculateTotal()
        }
        radio15.setOnClickListener(){
            tipVal = 0.15
            calculateTotal()
        }
        radio20.setOnClickListener(){
            tipVal = 0.20
            calculateTotal()
        }
        radio25.setOnClickListener(){
            tipVal = 0.25
            calculateTotal()
        }
        radio0.setOnClickListener(){
            tipVal = 0.0
            calculateTotal()
        }

        placeOrderButton.setOnClickListener(){
            Log.i("edu.itesm.ubereatssim", "Se confirmó la orden con un monto de $ $finalPrice MXN")
            subtotalVal = 0.0
            editSubtotal.setText("0")
            smallOrderVal = 0.0
            editSmallOrder.text = "$" + smallOrderVal.toString()
            serviceFeeVal = 0.0
            editServiceFee.text = "$" + serviceFeeVal.toString()
            deliveryFeeVal = 0.0
            editDeliveryFee.text = "$" + deliveryFeeVal.toString()
            finalPrice = 0.0

            val datoLista = Intent(this, ListaActivity::class.java)
            startActivity(datoLista)
        }

    }

    fun calculateTotal(){
        finalPrice = subtotalVal + smallOrderVal + serviceFeeVal + deliveryFeeVal + subtotalVal * tipVal
        placeOrderButton.text = "Place Order - Delivery    $" + finalPrice
    }
}