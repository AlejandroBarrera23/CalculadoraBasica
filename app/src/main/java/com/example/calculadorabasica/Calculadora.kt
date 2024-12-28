package com.example.calculadorabasica.calculadora

class Calculadora {
    private var entradaActual = StringBuilder()
    private var primerOperando: Double? = null
    private var operador: String? = null

    fun agregarNumero(numero: String) {
        entradaActual.append(numero)
    }

    fun establecerOperador(op: String) {
        if (entradaActual.isNotEmpty()) {
            primerOperando = entradaActual.toString().toDouble()
            operador = op
            entradaActual.clear()
        }
    }

    fun calcular(): String? {
        if (operador == null || primerOperando == null || entradaActual.isEmpty()) {
            return null
        }
        val segundoOperando = entradaActual.toString().toDouble()
        val resultado = when (operador) {
            "+" -> primerOperando!! + segundoOperando
            "-" -> primerOperando!! - segundoOperando
            "*" -> primerOperando!! * segundoOperando
            "/" -> if (segundoOperando != 0.0) primerOperando!! / segundoOperando else return null
            else -> return null
        }
        limpiar()
        return resultado.toString()
    }

    fun limpiar() {
        entradaActual.clear()
        primerOperando = null
        operador = null
    }

    fun obtenerEntradaActual(): String = entradaActual.toString()
}