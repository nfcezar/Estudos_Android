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
                    val intent = Intent(this@MainActivity, ConfirmationOrder::class.java)
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

