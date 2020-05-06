package com.example.usuario.demo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

      var Costo:Double=0.0
      var Cantidad:Double=0.0
      var Total:Double=0.0
      var Descuento:Double=0.0
      var CostoDelivery:Double=0.0
      var TotalPagar:Double=0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun Calculartotales():Boolean
    {
     if(EdtCosto.text.isEmpty()|| EdtCosto.text.equals("0"))
     {
         Toast.makeText(baseContext,"por favor ingresar el costo",Toast.LENGTH_LONG).show()
         return false
     }
        if (EdtCantidad.text.isEmpty() || EdtCantidad.text.equals("0"))
        {
            Toast.makeText(baseContext,"por favor ingresar la cantidad",Toast.LENGTH_LONG).show()
            return false
        }
        Costo=EdtCosto.text.toString().toDouble()
        Cantidad=EdtCantidad.text.toString().toDouble()
        Total=Costo*Cantidad

        if (Total >300)
        {
            Descuento=Total *0.10
        }
        if (chkDelivery.isChecked)
        {
        CostoDelivery=20.0
        }
        TotalPagar=(Total-Descuento)+CostoDelivery
        return true;
    }
    public fun btnCalcularClick(v: View)
    {
        if (Calculartotales())
        {
            EdtTotal.setText(Total.toString())
            EdtDescuento.setText(Descuento.toString())
            EdtTotalPagar.setText(TotalPagar.toString())

        }
    }
    public  fun btnImprimir_OnClick(v: View)
    {
        if (Calculartotales())
        {
            EdtTotal.setText(Total.toString())
            EdtDescuento.setText(Descuento.toString())
            EdtTotalPagar.setText(TotalPagar.toString())


            var oVentanaImprimir:Intent= Intent(this,Main2Activity::class.java)
            oVentanaImprimir.putExtra("DetallePedido",EdtDetallePedido.text)
            oVentanaImprimir.putExtra("Costo",EdtCosto.text)
            oVentanaImprimir.putExtra("Cantidad",EdtCantidad.text)
            oVentanaImprimir.putExtra("Total",EdtTotal.text)
            oVentanaImprimir.putExtra("Descuento",EdtDescuento.text)
            oVentanaImprimir.putExtra("Delivery",CostoDelivery.toString())
            oVentanaImprimir.putExtra("TotalPagar",TotalPagar.toString())
            startActivity(oVentanaImprimir)
        }
    }

}




