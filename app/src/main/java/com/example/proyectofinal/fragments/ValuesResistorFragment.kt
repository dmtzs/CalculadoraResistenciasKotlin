package com.example.proyectofinal.fragments

/*@Autor: Diego Martínez Sánchez
* @Descripción: Fragmento en el cual se mostrará las opciones en las que el usuario podra seleccionar un valor inicial, un multiplicador y un valor de tolerancia para poder verificar el código de colores de una resistencia.
*               De igual manera por cada opción que sale en los spinner y se seleccione, se cambia el código de colores e indica si el valor de la resistencia resultante existe comercialmente o no.*/

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.proyectofinal.Modelo
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_values_resistor.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG="Resistor"

class ValuesResistorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val mod= Modelo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onStart() {
        super.onStart()
        val appCompatActivity = activity as AppCompatActivity
        appCompatActivity.supportActionBar?.setTitle(R.string.app_name)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflar el layout para este fragmento.
        return inflater.inflate(R.layout.fragment_values_resistor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aquí validar cuando se inserte algo al widget para cambiar de colores
        //es decir, poner el setOnClickListener
        botRes1_2.isEnabled= false
        botRes2_2.isEnabled= false
        botRes3_2.isEnabled= false
        tole2.isEnabled= false
        val resuls = arrayOf("1.0", "Ω", "±1%", "1")//valor, multiplicador unidad, tolerancia y multiplicador valor.
        var resultado: String

        val lista= resources.getStringArray(R.array.valores_definitivo)
        val adaptador= ArrayAdapter(context!!, android.R.layout.simple_spinner_item, lista)
        spinner.adapter= adaptador

        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val posSpin= spinner.selectedItemPosition
                resuls[0]= spinner.getItemAtPosition(posSpin).toString()
                val ambosColores= mod.colores13Valores[posSpin].split(",")
                botRes1_2.setBackgroundColor(Color.parseColor(ambosColores[0]))
                botRes2_2.setBackgroundColor(Color.parseColor(ambosColores[1]))
                Log.d(TAG, "Ambos colores: $ambosColores")
                resultado= calcularCadenaReal(resuls)
                valorReal.text= resultado
                existencia.text= validarExistencia(resultado)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //No necesario
            }
        }
        //----------------------------------------------------------------------------------------

        spinnerTole.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val posTole= spinnerTole.selectedItemPosition
                resuls[2]= spinnerTole.getItemAtPosition(posTole).toString()
                tole2.setBackgroundColor(Color.parseColor(mod.tolerancias[posTole]))
                Log.d(TAG, "Posición seleccionada tole: $posTole")
                resultado= calcularCadenaReal(resuls)
                valorReal.text= resultado
                existencia.text= validarExistencia(resultado)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                //No necesario
            }
        }

        spinner2.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val posMulti= spinner2.selectedItemPosition

                val eder= spinner2.getItemAtPosition(posMulti).toString()
                val eder2= eder.split(" ")
                val eder3= eder2[0].replace("x", "")
                Log.d(TAG, "Después de espacios: ${eder2[1]}")
                Log.d(TAG, "Item seleccionado final: $eder3")

                resuls[1]= eder2[1]
                resuls[3]= eder3
                botRes3_2.setBackgroundColor(Color.parseColor(mod.coloresValores2Opcion[posMulti]))
                Log.d(TAG, "Posición seleccionada multi: $posMulti")
                resultado= calcularCadenaReal(resuls)
                valorReal.text= resultado
                existencia.text= validarExistencia(resultado)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //No necesario
            }
        }
    }

    private fun calcularCadenaReal(resuls: Array<String>): String
    {
        //valor, multiplicador unidad, tolerancia y multiplicador valor.
        val valor= resuls[0].toFloat()
        val multiValor= resuls[3].toFloat()

        val otroResul= valor * multiValor

        return "$otroResul ${resuls[1]} ${resuls[2]}"
    }

    private fun validarExistencia(cadena: String): String {
        Log.d(TAG, "Parametro recibido: $cadena")
        val aux= cadena.split(" ")

        return if (aux[1]== "MΩ" && aux[0].toFloat()> 10.0)
        {
            val nuecade= "El valor de esta resistencia no existe comercialmente"
            nuecade
        }
        else
        {
            val nuecade= "El valor de esta resistencia existe comercialmente"
            nuecade
        }
    }
}