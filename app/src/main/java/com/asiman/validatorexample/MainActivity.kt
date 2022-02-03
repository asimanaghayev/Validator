package com.asiman.validatorexample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.asiman.validator.ValidationBinder
import com.asiman.validatorexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bindind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindind.root)

        bindind.btnContinue.setOnClickListener {
            Toast.makeText(this,
                "Continue clicked...",
                Toast.LENGTH_SHORT).show()
        }

        // for initializing Validator
        ValidationBinder.bind(bindind.btnContinue, bindind.inputFirst, bindind.inputSecond)
    }
}