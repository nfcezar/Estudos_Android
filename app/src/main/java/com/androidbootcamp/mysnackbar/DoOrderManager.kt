package com.androidbootcamp.mysnackbar

class DoOrderManager(val manager: SharedPreferencesManager) {

    fun doOrder(qtd: Int, code: Int): OrderResult {
        Code.getCode(code)?.let {
            val result = order(it, qtd)

            //Insere o valor do conjunto chave-valor no SharedPrefrences
            manager.saveIntOnPreferences("key_codigo", code)
            manager.saveIntOnPreferences("key_quantidade", qtd)
            manager.saveFloatOnPreferences("key_preco", result.price)

            return OrderResult.SUCCESS
        }
        return OrderResult.FAILURE
    }

}

