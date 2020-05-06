package com.example.usuario.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        edtDetalleImpresion.setText(intent.extras!!["DetallePedido"]!!.toString())
        edtCostoImpresion.setText(intent.extras!!["Costo"]!!.toString())
        edtCantidaImpresion.setText(intent.extras!!["Cantidad"]!!.toString())
    }

}
