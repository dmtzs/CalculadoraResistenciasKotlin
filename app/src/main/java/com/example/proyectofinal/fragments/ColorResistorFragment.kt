package com.example.proyectofinal.fragments

/*@Autor: Diego Martínez Sánchez
* @Descripción: Fragmento en el cual se mostrará una resistencia en la que se debe presionar sobre sus bandas para cambiar el color de la misma y posteriormente debajo de la misma se mostrará el valor de la resistencia a la que corresponde.
*               Los botones denajo de las bandas como la leyenda que sale a la izquierda indica es para regresar al valor del color anterior en caso nos hayamos pasado de color.
*               Al igual que el otro fragmento este indica si el valor de la resistencia existe o no y solo sería ver si el color de la resistencia existe o no aunque esto no es realmente necesario-
*               ya que este fragmento está pensado para calcular el valor de la resistencia a través de su código de colores de cuya resistencia ya se tiene en mano físicamente hablando.*/

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.Modelo
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_color_resistor.*

//Inicialización de los parámetros del fragmento.
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG="Resistor"

class ColorResistorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val mod= Modelo()//Instancio mi clase de modelo.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflar el layout para este fragmento.
        return inflater.inflate(R.layout.fragment_color_resistor, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var bande1= 0
        var bande2= 0
        var bande3= 0
        var bandeTole= 0
        var valorResisFinal: String
        val resuls = arrayOf(0F, 0F, 1F, 1.0F)//banda1, banda2, banda3, banda4.
        val lista= resources.getStringArray(R.array.values_resis)//Obtener los valores de las 91 resistencias desde mi string array.
        Log.d(TAG, "Arre: ${lista[14]}")
        super.onViewCreated(view, savedInstanceState)
        botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
        botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
        botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))

        indice1.text= "1"
        indice2.text= "2"
        indice3.text= "3"
        indice4.text= "4"

        tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
        resultado.text= calculosValores(resuls).toString()+" Ω ±${mod.toleranciasValores[bandeTole]}%"
        comer.text= ""

        botResis1.setOnClickListener{
            if (bande1== 9)
            {
                bande1= 0
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
                //Log.d(TAG, "Resul multiplicacion $final")
            }
            else
            {
                bande1+= 1
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
                //Log.d(TAG, "Resul multiplicacion $final")
            }
        }

        bola1.setOnClickListener {
            if (bande1== 0)
            {
                bande1= 9
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bande1-= 1
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
                //Log.d(TAG, "Resul multiplicacion $final")
            }
        }

        botResis2.setOnClickListener{
            if (bande2== 9)
            {
                bande2= 0
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bande2+= 1
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
        }

        bola2.setOnClickListener {
            if (bande2== 0)
            {
                bande2= 9
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bande2-= 1
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
        }

        botResis3.setOnClickListener {
            if (bande3== 11)
            {
                bande3= 0
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bande3+= 1
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)

            }
        }

        bola3.setOnClickListener {
            if (bande3== 0)
            {
                bande3= 11
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bande3-= 1
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)

            }
        }

        tole.setOnClickListener {
            if (bandeTole== 8)
            {
                bandeTole= 0
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bandeTole+= 1
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
        }

        bola4.setOnClickListener {
            if (bandeTole== 0)
            {
                bandeTole= 8
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
            else
            {
                bandeTole-= 1
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                valorResisFinal= unidades(calculosValores(resuls), resuls[3])
                resultado.text= valorResisFinal
                comer.text= comercialsino(lista, valorResisFinal)
            }
        }
    }

    private fun calculosValores(arre: Array<Float>): Float
    {
        var final= arre[0]+arre[1]
        final*= arre[2]

        return final
    }

    private fun unidades(resultadoFinal: Float, tolerancia: Float): String
    {
        var cade= ""
        if (resultadoFinal<1000)
        {
            cade= "%.1f".format(resultadoFinal)//Ya lo convierte a cadena
            cade+= " Ω ±$tolerancia%"
        }
        else if (resultadoFinal>=1000 && resultadoFinal<1000000)
        {
            val aux= resultadoFinal/1000F
            cade= "%.1f".format(aux)
            cade+= " KΩ ±$tolerancia%"
        }
        else if (resultadoFinal>=1000000)
        {
            val aux= resultadoFinal/1000000F
            cade= "%.1f".format(aux)
            cade+= " MΩ ±$tolerancia%"
        }
        return cade
    }

    private fun comercialsino(arre: Array<String>, cade: String): String
    {
        val aux= cade.split("±")
        var aux2= aux[0]
        aux2= aux2.dropLast(1)//Elimino el último espacio de mi cadena.

        return if (aux2 in arre)
        {
            val nueCade= "Este valor existe comercialmente, verifica con tu proveedor el código de colores correcto de ser necesario"
            nueCade
        }
        else
        {
            val nueCade= "Este valor no existe comercialmente"
            nueCade
        }
    }
}