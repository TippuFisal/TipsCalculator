package com.sheriff.tipscalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sheriff.tipscalculator.databinding.ActivityTipsCalculatorBinding
import java.text.NumberFormat

class TipsCalculatorActivity : AppCompatActivity() {

    lateinit var binding: ActivityTipsCalculatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTipsCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        calculateTips()
    }

    /**
     * calculateTips
     */
    private fun calculateTips() {
        binding.btnCalculate.setOnClickListener { // button setOnClickListener
            val stringInTextField = binding.etCostOfService.text.toString() // get String from user
            val cost = stringInTextField.toDoubleOrNull() // convert user input to Double
            when {
                cost == null -> { // check cost is null or not
                    binding.tvTipsAmount.text = ""
                    return@setOnClickListener
                }
            }

            // Get selected Value to calculate the percentage
            val selectedId = binding.rgTipsPercentage.checkedRadioButtonId
            val tipPercentage = when (selectedId) {
                R.id.rbAmazing -> 0.20
                R.id.rbGood -> 0.18
                R.id.rbOkay -> 0.15
                else -> 0.00
            }

            // Multiply total amount with percentage
            var tipAmount = tipPercentage * cost!!

            // Check if roundUp is Enable or not
            val roundUp = binding.switchToRoundTips.isChecked
            when (roundUp) {
                true -> {
                    tipAmount = kotlin.math.ceil(tipAmount) // convert to roundUp value
                }
            }

            // Currency Formatting
            val finalTipAmount = NumberFormat.getCurrencyInstance().format(tipAmount)

            // Set final value
            binding.tvTipsAmount.text = getString(R.string.tip_amount, finalTipAmount)
        }
    }
}