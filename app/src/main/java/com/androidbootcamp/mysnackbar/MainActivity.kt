package com.androidbootcamp.mysnackbar

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.androidbootcamp.mysnackbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferencesManager: SharedPreferencesManager
    private lateinit var doOrderManager: DoOrderManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initializeManagers()

        setClickListeners()
    }

    private fun btnConfirmOnClick() =
        when (doOrderManager.doOrder(binding.edtQuantidade.toInt(), binding.edtCodigo.toInt())) {
            OrderResult.SUCCESS -> startNavigation()
            OrderResult.FAILURE -> showErrorMessage()

        }

    private fun startNavigation() {
        val intent = Intent(this, ConfirmationOrderActivity::class.java)
        startActivity(intent)
    }

    private fun showErrorMessage() =
        Toast.makeText(application, ERROR_CODE, Toast.LENGTH_LONG).show()


    private fun initializeManagers() {
        sharedPreferencesManager = SharedPreferencesManager(this)
        doOrderManager = DoOrderManager(sharedPreferencesManager)
    }

    private fun setClickListeners() {
        binding.btnConfirmPedido.setOnClickListener {
            btnConfirmOnClick()
        }
    }

    companion object {
        private const val ERROR_CODE = "Código Inválido"
    }
}









