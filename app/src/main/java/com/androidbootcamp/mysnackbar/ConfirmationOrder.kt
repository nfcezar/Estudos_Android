package com.androidbootcamp.mysnackbar

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

        with(binding) {


        }
    }


}