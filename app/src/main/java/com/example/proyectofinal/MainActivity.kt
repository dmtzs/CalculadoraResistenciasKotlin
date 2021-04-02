package com.example.proyectofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.proyectofinal.fragments.ColorResistorFragment
import com.example.proyectofinal.fragments.ValuesResistorFragment
import kotlinx.android.synthetic.main.activity_main.*//Se agrego en el gradle para poder importar esto

class MainActivity : AppCompatActivity() {
    private val colorResistor= ColorResistorFragment()
    private val valuesResistor= ValuesResistorFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(colorResistor)

        bottom_navigation.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.ic_1 -> replaceFragment(colorResistor)
                R.id.ic_2 -> replaceFragment(valuesResistor)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment!= null)
        {
            val transaccion= supportFragmentManager.beginTransaction()
            transaccion.replace(R.id.fragment_container, fragment)
            transaccion.commit()
        }
    }
}