package com.androidbootcamp.mysnackbar

import android.widget.EditText

fun order(meal: Meal, qtd: Int): Result {

    val finalPrice = when (meal) {
        Meal.CACHORRO_QUENTE -> (qtd * Price.PRICE1.price)
        Meal.BAURU_SIMPLES -> (qtd * Price.PRICE2.price)
        Meal.BAURU_COM_OVO -> (qtd * Price.PRICE3.price)
        Meal.HAMBURGUER -> (qtd * Price.PRICE1.price)
        Meal.CHEESEBURGUER -> (qtd * Price.PRICE2.price)
        Meal.REFRIGERANTE -> (qtd * Price.PRICE4.price)
    }
    return Result(meal, finalPrice, qtd)
}

fun EditText.toInt(): Int {
    return this.text.toString().toInt()
}











