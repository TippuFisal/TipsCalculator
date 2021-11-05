package com.sheriff.tipscalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sheriff.tipscalculator.databinding.ActivityTipsCalculatorBinding

class TipsCalculatorActivity : AppCompatActivity() {

    lateinit var binding : ActivityTipsCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initUI(){

    }

    private fun calculateTips(){

    }
}