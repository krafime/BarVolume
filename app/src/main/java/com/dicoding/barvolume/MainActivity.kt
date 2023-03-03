package com.dicoding.barvolume

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(){
    private lateinit var etWidth: EditText
    private lateinit var etHeight: EditText
    private lateinit var etLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    @SuppressLint("MissingInflatedId")

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWidth = findViewById(R.id.et_Width)
        etHeight = findViewById(R.id.et_Height)
        etLength = findViewById(R.id.et_Length)
        btnCalculate = findViewById(R.id.btn_Calculate)
        tvResult = findViewById(R.id.tv_Result)

        btnCalculate.setOnClickListener{
            if(it?.id == R.id.btn_Calculate) {
                val inputLength = etLength.text.toString().trim()
                val inputWidth = etWidth.text.toString().trim()
                val inputHeight = etHeight.text.toString().trim()

                var isEmptyFields = false

                if (inputLength.isEmpty()){
                    isEmptyFields = true
                    etLength.error = "Field Panjang tidak boleh kosong!"
                }

                if (inputWidth.isEmpty()){
                    isEmptyFields = true
                    etWidth.error = "Field Lebar tidak boleh kosong!"
                }

                if (inputHeight.isEmpty()){
                    isEmptyFields = true
                    etHeight.error = "Field Tinggi tidak boleh kosong!"
                }

                if (!isEmptyFields) {
                    val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                    tvResult.text = volume.toString()
                }
            }
        }

        if (savedInstanceState != null) {
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

//    override fun onClick(v: View?) {
//        if(v?.id == R.id.btn_Calculate) {
//            val inputLength = etLength.text.toString().trim()
//            val inputWidth = etWidth.text.toString().trim()
//            val inputHeight = etHeight.text.toString().trim()
//
//            var isEmptyFields = false
//
//            if (inputLength.isEmpty()){
//                isEmptyFields = true
//                etLength.error = "Field Panjang tidak boleh kosong!"
//            }
//
//            if (inputWidth.isEmpty()){
//                isEmptyFields = true
//                etWidth.error = "Field Lebar tidak boleh kosong!"
//            }
//
//            if (inputHeight.isEmpty()){
//                isEmptyFields = true
//                etHeight.error = "Field Tinggi tidak boleh kosong!"
//            }
//
//            if (!isEmptyFields) {
//                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
//                tvResult.text = volume.toString()
//            }
//        }
   // }
}
