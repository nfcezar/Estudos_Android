package com.androidbootcamp.mysnackbar

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.androidbootcamp.mysnackbar.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        with(binding) {
            btnConfirmPedido.setOnClickListener {
                Code.getCode(edtCodigo.text.toString().toInt())?.let {

                    val result = order(it, edtQuantidade.text.toString().toInt())

                    //Alocação do shared preferences
                    val sharedPreferences = getSharedPreferences(
                        getString(R.string.preference_key),
                        Context.MODE_PRIVATE

                    )
                    /* val sharedEditor = sharedPreferences.edit()
                     sharedEditor.putInt("key_test", 99)
                     sharedEditor.apply()

                     with(sharedPreferences.edit()) {
                         this.putInt("key_test", 99)
                         this.apply()
                     }*/

                    //Insere o valor do conjunto chave-valor no SharedPrefrences
                    with(sharedPreferences.edit()) {
                        putInt("key_codigo", edtCodigo.text.toString().toInt())
                        putInt("key_quantidade", edtQuantidade.text.toString().toInt())
                        putFloat("key_preco", result.price)
                        apply()
                    }

                    //Resgate do valor através da chave no arquivo gerado.

                   /* val codigo = sharedPreferences.getInt("key_codigo", 0)
                    val quantidade = sharedPreferences.getInt("key_quantidade", 0)
                    val preco = sharedPreferences.getFloat("key_preco", 0F)

                    println("$codigo")
                    println("$quantidade")
                    println("$preco")*/

                    val intent = Intent(this@MainActivity, ConfirmationOrder::class.java).apply {
                       /* putExtra("Code", edtCodigo.text.toString())
                        putExtra("Qtd", edtQuantidade.text.toString())
                        putExtra("Price", result.price.toString())*/
                    }

                    // Toast.makeText(application, "$result", Toast.LENGTH_LONG).show()

                    startActivity(intent)

                } ?: Toast.makeText(application, "Valor Inválido", Toast.LENGTH_LONG).show()
            }

            /*val code = Code.getCode(edtCode.text.toString().toInt())
            if (code != null) {
                val result = order(code, edtQtd.text.toString().toInt())

                Toast.makeText(application, "$result", Toast.LENGTH_LONG).show()*/
        }
    }
}

