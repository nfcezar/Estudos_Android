package com.androidbootcamp.mysnackbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidbootcamp.mysnackbar.databinding.OrderConfirmationBinding

class ConfirmationOrder : AppCompatActivity() {

    private lateinit var binding: OrderConfirmationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OrderConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*val cod = intent.getStringExtra("Code")
        val qtd = intent.getStringExtra("Qtd")
        val price = intent.getStringExtra("Price")*/

        with(binding) {

            //Abre o arquivo SharedPreferences e salva na variável "sharedPreferences"
            val sharedPreferences = getSharedPreferences(
                getString(R.string.preference_key),
                Context.MODE_PRIVATE)


            //Resgate do valor através da chave no arquivo gerado.
            val codigo = sharedPreferences.getInt("key_codigo", 0)
            val quantidade = sharedPreferences.getInt("key_quantidade", 0)
            val preco = sharedPreferences.getFloat("key_preco", 0F)


            textviewCodigo.apply { text = codigo.toString() }
            textviewQuantidade.apply { text = quantidade.toString() }
            textviewValor.apply { text = preco.toString() }
        }
    }


}