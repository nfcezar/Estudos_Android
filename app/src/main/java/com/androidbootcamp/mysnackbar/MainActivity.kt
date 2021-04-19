package com.androidbootcamp.mysnackbar

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    private lateinit var edtCode: EditText
    private lateinit var edtQtd: EditText
    private lateinit var btnConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtCode = findViewById(R.id.edt_codigo)
        edtQtd = findViewById(R.id.edt_quantidade)
        btnConfirm = findViewById(R.id.btn_confirm_pedido)

        Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()

        btnConfirm.setOnClickListener {

            Code.getCode(edtCode.text.toString().toInt())?.let {
                val result = order(it, edtQtd.text.toString().toInt())

                Toast.makeText(application, "$result", Toast.LENGTH_LONG).show()

            } ?: Toast.makeText(application, "Valor Inválido", Toast.LENGTH_LONG).show()


            /*val code = Code.getCode(edtCode.text.toString().toInt())
            if (code != null) {
                val result = order(code, edtQtd.text.toString().toInt())

                Toast.makeText(application, "$result", Toast.LENGTH_LONG).show()*/

        }


    }

}