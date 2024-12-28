package com.example.calculadorabasica

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculadorabasica.calculadora.Calculadora

class MainActivity : AppCompatActivity() {

    private lateinit var pantalla: TextView
    private val calculadora = Calculadora()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pantalla = findViewById(R.id.textViewPantalla)

        val botones = listOf(
            R.id.boton0 to "0",
            R.id.boton1 to "1",
            R.id.boton2 to "2",
            R.id.boton3 to "3",
            R.id.boton4 to "4",
            R.id.boton5 to "5",
            R.id.boton6 to "6",
            R.id.boton7 to "7",
            R.id.boton8 to "8",
            R.id.boton9 to "9",
            R.id.botonSumar to "+",
            R.id.botonRestar to "-",
            R.id.botonMultiplicar to "*",
            R.id.botonDividir to "/",
            R.id.botonLimpiar to "C",
            R.id.botonIgual to "="
        )

        botones.forEach { (id, valor) ->
            findViewById<Button>(id).setOnClickListener { alPresionarBoton(valor) }
        }
    }

    private fun alPresionarBoton(valor: String) {
        when (valor) {
            "C" -> {
                calculadora.limpiar()
                pantalla.text = ""
            }
            "=" -> {
                val resultado=calculadora.calcular()
                pantalla.text=resultado ?: "Error"
            }
            in listOf("+", "-", "*", "/") -> {
                calculadora.establecerOperador(valor)
                pantalla.text=""
            }
            else -> {
                calculadora.agregarNumero(valor)
                pantalla.text = calculadora.obtenerEntradaActual()
            }
        }
    }
}