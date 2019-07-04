package com.example.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalcular) {
            realizarCalculo()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalcular.setOnClickListener(this)
    }

    private fun realizarCalculo() {
        if (ehValido()) {
            try {
                val distancia = editDistancia.text.toString().toFloat()
                val preco = editPreco.text.toString().toFloat()
                val autonomia = editAutonomia.text.toString().toFloat()

                val resultado = ((distancia * preco) / autonomia)

                textValor.text = "Total: R$ $resultado"

            } catch (nfe: NumberFormatException) {
                toast(getString(R.string.valores_validos))
            }

        } else {
            toast(getString(R.string.campos_vazios))
        }
    }

    private fun ehValido(): Boolean {
        return editDistancia.text.toString() != ""
                && editPreco.text.toString() != ""
                && editAutonomia.text.toString() != ""
                && editAutonomia.text.toString() != "0"
    }

}
