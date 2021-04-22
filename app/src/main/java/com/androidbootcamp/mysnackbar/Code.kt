package com.androidbootcamp.mysnackbar

enum class Code(val code: Int) {
    CACHORRO_QUENTE(100),
    BAURU_SIMPLES(101),
    BAURU_COM_OVO(102),
    HAMBURGUER(103),
    CHEESEBURGUER(104),
    REFRIGERANTE(105);


    companion object {
        fun getCode(code: Int): Code? {
            return values().firstOrNull { it.code == code }
        }
    }
}

