package com.androidbootcamp.mysnackbar

enum class Meal(val code: Int, val snack: String) {
    CACHORRO_QUENTE(100, "CACHORRO QUENTE"),
    BAURU_SIMPLES(101,"BAURU SIMPLES"),
    BAURU_COM_OVO(102,"BAURU COM OVO"),
    HAMBURGUER(103,"HAMBURGUER"),
    CHEESEBURGUER(104,"CHEESEBURGUER"),
    REFRIGERANTE(105,"REFRIGERANTE");


    companion object {
        fun getMealFromCode(givenCode: Int): Meal? {
            return values().firstOrNull { it.code == givenCode }
        }
    }
}

