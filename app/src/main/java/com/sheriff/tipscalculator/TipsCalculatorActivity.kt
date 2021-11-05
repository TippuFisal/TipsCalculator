package com.sheriff.tipscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sheriff.tipscalculator.databinding.ActivityTipsCalculatorBinding
import java.text.NumberFormat
import kotlin.math.cos

class TipsCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityTipsCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        calculateTips()
    }

    private fun calculateTips() {
        binding.btnCalculate.setOnClickListener {
            val stringInTextField = binding.etCostOfService.text.toString()
            val cost = stringInTextField.toDoubleOrNull()
            when{
                cost == null ->{
                    binding.tvTipsAmount.text = ""
                    return@setOnClickListener
                }
            }
            val selectedId = binding.rgTipsPercentage.checkedRadioButtonId
            val tipPercentage = when(selectedId){
                R.id.rbAmazing -> 0.20
                R.id.rbGood -> 0.18
                R.id.rbOkay -> 0.15
                else -> 0.00
            }
            var tipAmount = tipPercentage * cost!!
            val roundUp = binding.switchToRoundTips.isChecked
            when(roundUp){
                true -> {
                    tipAmount = kotlin.math.ceil(tipAmount)
                }
            }
            val finalTipAmount = NumberFormat.getCurrencyInstance().format(tipAmount)
            binding.tvTipsAmount.text = getString(R.string.tip_amount, finalTipAmount)
        }
    }
}