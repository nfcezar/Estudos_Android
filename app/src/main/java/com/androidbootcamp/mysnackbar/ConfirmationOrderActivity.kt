package com.androidbootcamp.mysnackbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.androidbootcamp.mysnackbar.databinding.OrderConfirmationBinding

class ConfirmationOrderActivity : AppCompatActivity() {

    private lateinit var binding: OrderConfirmationBinding
    private lateinit var sharedPreferencesManager: SharedPreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = OrderConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferencesManager = SharedPreferencesManager(this)

        with(binding) {

            //Resgate do valor através da chave no arquivo gerado.
            val codigo = sharedPreferencesManager.getIntValue("key_codigo")
            val quantidade = sharedPreferencesManager.getIntValue("key_quantidade")
            val preco = sharedPreferencesManager.getFloatValue("key_preco")
            val snack = Meal.getMealFromCode(codigo)?.snack ?: ""

            textviewCodigo.apply { text = codigo.toString() }
            textviewQuantidade.apply { text = quantidade.toString() }
            textviewValor.apply { text = preco.toString() }
            textviewSnackDesc.apply { text = snack }

        }
    }
}