package com.example.proyectofinal

class Modelo {
    val coloresBandas= arrayOf<String>("#010101", "#551E12", "#FB0000", "#FF8000", "#FFFF00", "#5FE506", "#13ECF1", "#A524E2", "#828282", "#F4F4F4", "#FFCD48", "#CDCDCD")
    //Negro, Cafe, Rojo, Naranja, Amarillo, Verde, Azul claro, Morado/Violeta, Gris, Blanco, amarillo opaco, gris claro

    val tolerancias= arrayOf<String>("#551E12", "#FB0000", "#FFFF00", "#5FE506", "#13ECF1", "#A524E2", "#828282", "#FFCD48", "#CDCDCD")//Implementar cambio de colores en este último boton y el otro string array en el xml
    //Cafe, Rojo, Amarillo claro, Verde, Azul claro, Morado/Violeta, Gris, Amarillo opaco, gris claro

    val primeraBandaValores= arrayOf<Float>(0F, 10F, 20F, 30F, 40F, 50F, 60F, 70F, 80F, 90F)//ohms
    val segundaBandaValores= arrayOf<Float>(0F, 1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F)//ohms
    //Primeras 2 bandas se suman nada mas mutuamente, para estos valores la secuancia de colores es la misma que la del primer arreglo

    val terceraBandaValor= arrayOf<Float>(1F, 10F, 100F, 1000F, 10000F, 100000F, 1000000F, 10000000F, 100000000F, 1000000000F, 0.1F, 0.01F)
    //Negro, Cafe, Rojo, Naranja, Amarillo, Verde, Azul claro, Morado/Violeta, Gris, Blanco, Amarillo caca, gris claro: #CDCDCD
    //Esta se multiplica por las 2 bandas anteriores.

    //Implementar arreglo en la que estén los colores de las bandas para poder mostrar los colores acorde al valor seleccionado
}