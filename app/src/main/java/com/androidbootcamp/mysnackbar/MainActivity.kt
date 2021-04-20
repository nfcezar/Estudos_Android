package com.androidbootcamp.mysnackbar

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidbootcamp.mysnackbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getPreferences()

        binding.btnConfirmPedido.setOnClickListener {
            btnConfirmOnClick()
        }
    }

    private fun getPreferences(): SharedPreferences {
        //Alocação do shared preferences
        return getSharedPreferences(
            getString(R.string.preference_key),
            Context.MODE_PRIVATE
        )
    }

    private fun saveIntOnPreferences(key: String, value: Int) {
        sharedPreferences.edit()
            .putInt(key, value)
            .apply()
    }

    private fun saveFloatOnPreferences(key: String, value: Float) {
        sharedPreferences.edit()
            .putFloat(key, value)
            .apply()
    }

    private fun btnConfirmOnClick() {
        with(binding) {
            Code.getCode(edtCodigo.toInt())?.let {

                val result = order(it, edtQuantidade.toInt())

                //Insere o valor do conjunto chave-valor no SharedPrefrences
                saveIntOnPreferences("key_codigo", edtCodigo.toInt())
                saveIntOnPreferences("key_quantidade", edtQuantidade.toInt())
                saveFloatOnPreferences("key_preco", result.price)

                val intent = Intent(this@MainActivity, ConfirmationOrder::class.java)
                startActivity(intent)

            } ?: Toast.makeText(application, "Valor Inválido", Toast.LENGTH_LONG).show()

        }
    }
}

