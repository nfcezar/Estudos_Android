package com.androidbootcamp.mysnackbar

import android.content.Context
import android.content.SharedPreferences
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivity
import com.androidbootcamp.mysnackbar.databinding.ActivityMainBinding

fun order(code: Code, qtd: Int): Result {

    val finalPrice = when (code) {
        Code.CACHORRO_QUENTE -> (qtd * Price.PRICE1.price)
        Code.BAURU_SIMPLES -> (qtd * Price.PRICE2.price)
        Code.BAURU_COM_OVO -> (qtd * Price.PRICE3.price)
        Code.HAMBURGUER -> (qtd * Price.PRICE1.price)
        Code.CHEESEBURGUER -> (qtd * Price.PRICE2.price)
        Code.REFRIGERANTE -> (qtd * Price.PRICE4.price)
    }
    return Result(code, finalPrice, qtd)
}

fun EditText.toInt(): Int {
    return this.text.toString().toInt()
}











