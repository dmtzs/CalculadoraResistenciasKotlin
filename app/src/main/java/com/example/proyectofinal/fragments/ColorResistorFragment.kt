package com.example.proyectofinal.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.proyectofinal.Modelo
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_color_resistor.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
//private const val TAG="Resistor"

class ColorResistorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val mod= Modelo()//Instancio mi clase de modelo

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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_color_resistor, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var bande1= 0
        var bande2= 0
        var bande3= 0
        var bandeTole= 0
        val resuls = arrayOf<Float>(0F, 0F, 1F, 1.0F)//banda1, banda2, banda3
        super.onViewCreated(view, savedInstanceState)
        botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
        botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
        botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
        tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
        resultado.text= calculosValores(resuls).toString()+" Ω ±${mod.toleranciasValores[bandeTole]}%"

        botResis1.setOnClickListener{
            if (bande1== 9)
            {
                bande1= 0
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
                //Log.d(TAG, "Resul multiplicacion $final")
            }
            else
            {
                bande1+= 1
                botResis1.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande1]))
                resuls[0]= mod.primeraBandaValores[bande1]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
                //Log.d(TAG, "Resul multiplicacion $final")
            }
        }

        botResis2.setOnClickListener{
            if (bande2== 9)
            {
                bande2= 0
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
            else
            {
                bande2+= 1
                botResis2.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande2]))
                resuls[1]= mod.segundaBandaValores[bande2]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
        }

        botResis3.setOnClickListener {
            if (bande3== 11)
            {
                bande3= 0
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
            else
            {
                bande3+= 1
                botResis3.setBackgroundColor(Color.parseColor(mod.coloresBandas[bande3]))
                resuls[2]= mod.terceraBandaValor[bande3]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
        }

        tole.setOnClickListener {
            if (bandeTole== 8)
            {
                bandeTole= 0
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
            else
            {
                bandeTole+= 1
                tole.setBackgroundColor(Color.parseColor(mod.tolerancias[bandeTole]))
                resuls[3]= mod.toleranciasValores[bandeTole]
                resultado.text= unidades(calculosValores(resuls), resuls[3])
            }
        }
    }

    fun calculosValores(arre: Array<Float>): Float
    {
        var final= arre[0]+arre[1]
        final*= arre[2]

        return final
    }

    fun unidades(resultadoFinal: Float, tolerancia: Float): String
    {
        var cade= ""
        if (resultadoFinal<1000)
        {
            val aux= resultadoFinal
            cade= "%.1f".format(aux)//Ya lo convierte a cadena
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
}