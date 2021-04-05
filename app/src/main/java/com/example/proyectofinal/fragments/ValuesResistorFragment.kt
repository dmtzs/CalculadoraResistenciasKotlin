package com.example.proyectofinal.fragments

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.proyectofinal.R
import kotlinx.android.synthetic.main.fragment_values_resistor.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val TAG="Resistor"

class ValuesResistorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_values_resistor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Aquí validar cuando se inserte algo al widget para cambiar de colores
        //es decir, poner el setOnClickListener
        botRes1_2.isEnabled= false
        botRes2_2.isEnabled= false
        botRes3_2.isEnabled= false

        botRes1_2.setBackgroundColor(Color.parseColor("#010101"))
        botRes2_2.setBackgroundColor(Color.parseColor("#010101"))
        botRes3_2.setBackgroundColor(Color.parseColor("#010101"))

        val lista= resources.getStringArray(R.array.values_array)
        val adaptador= ArrayAdapter(context!!, android.R.layout.simple_spinner_item, lista)
        spinner.adapter= adaptador

        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val eder= spinner.getItemAtPosition(spinner.selectedItemPosition).toString()
                Log.d(TAG, "Item seleccionado: $eder")
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        //val eder= spinner.getItemAtPosition(spinner.selectedItemPosition).toString()
        //Log.d(TAG, "Item seleccionado: $eder")


    }
}