package com.example.proyectofinal

/*@Autor: Diego Martínez Sánchez
* @Descripción: Modelo en el que están todos los arreglos en los que se contienen los colores y los valores correspondientes a las bandas de la resistencia a mostrar.
*               De igual manera para el caso de los colores de las resistencias tenemos un arreglo en el que validamos si lo que ingresó el usuario en la parte de colores es una resistencia comercial.*/
class Modelo {
    val coloresBandas= arrayOf<String>("#010101", "#551E12", "#FB0000", "#FF8000", "#FFFF00", "#5FE506", "#13ECF1", "#A524E2", "#828282", "#F4F4F4", "#FFCD48", "#CDCDCD")
    //Negro, Cafe, Rojo, Naranja, Amarillo, Verde, Azul claro, Morado/Violeta, Gris, Blanco, amarillo opaco, gris claro

    val tolerancias= arrayOf<String>("#551E12", "#FB0000", "#FFFF00", "#5FE506", "#13ECF1", "#A524E2", "#828282", "#FFCD48", "#CDCDCD")//Implementar cambio de colores en este último boton y el otro string array en el xml
    //Cafe, Rojo, Amarillo claro, Verde, Azul claro, Morado/Violeta, Gris, Amarillo opaco, gris claro
    val toleranciasValores= arrayOf<Float>(1.0F, 2.0F, 4.0F, 0.5F, 0.25F, 0.10F, 0.05F, 5.0F, 10.0F)

    val primeraBandaValores= arrayOf<Float>(0F, 10F, 20F, 30F, 40F, 50F, 60F, 70F, 80F, 90F)//ohms
    val segundaBandaValores= arrayOf<Float>(0F, 1F, 2F, 3F, 4F, 5F, 6F, 7F, 8F, 9F)//ohms
    //Primeras 2 bandas se suman nada mas mutuamente, para estos valores la secuancia de colores es la misma que la del primer arreglo

    val terceraBandaValor= arrayOf<Float>(1F, 10F, 100F, 1000F, 10000F, 100000F, 1000000F, 10000000F, 100000000F, 1000000000F, 0.1F, 0.01F)
    //Negro, Cafe, Rojo, Naranja, Amarillo, Verde, Azul claro, Morado/Violeta, Gris, Blanco, Amarillo caca, gris claro: #CDCDCD
    //Esta se multiplica por las 2 bandas anteriores.
}