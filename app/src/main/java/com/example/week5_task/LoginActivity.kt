package com.example.week5_task

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.week5_task.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private lateinit var binding: ActivityLoginBinding

    private val countries = arrayOf("Nepal", "US", "China", "Australia", "Thailand", "Portugal", "Maldives")
    private val cities = arrayOf("Kathmandu", "Lalitpur", "Bhaktapur", "Kanchanpur", "Kohalpur", "Bihar", "Bandipur", "Banepa", "Lhasa", "Lumbini")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up country spinner
        val countryAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, countries)
        binding.countrySpinner.adapter = countryAdapter
        binding.countrySpinner.onItemSelectedListener = this

        // Set up city AutoCompleteTextView
        val cityAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, cities)
        binding.autoCompleteCities.setAdapter(cityAdapter)
        binding.autoCompleteCities.threshold = 1

        binding.submitBtn.setOnClickListener {
            handleOnSubmit()
        }
    }

    private fun handleOnSubmit() {
        val fullName = binding.fullNameText.text.toString()
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()
        val selectedGenderId = binding.genderRadioGroup.checkedRadioButtonId
        val country = binding.countrySpinner.selectedItem.toString()
        val city = binding.autoCompleteCities.text.toString()

        // Validation
        if (fullName.isEmpty()) {
            binding.nameInputLayout.error = "Full Name is required"
        }
        if (email.isEmpty()) {
            binding.emailInputLayout.error = "Valid Email is required"
        }
        if (password.isEmpty() || password.length < 6) {
            binding.passwordInputLayout.error = "Password must be at least 6 characters"
        }
        if (selectedGenderId == -1) {
            Toast.makeText(this, "Please select a gender", Toast.LENGTH_SHORT).show()
            return
        }
        if (city.isEmpty()) {
            Toast.makeText(this, "Please select a city", Toast.LENGTH_SHORT).show()
            return
        }
        if (!binding.termsRadio.isChecked) {
            Toast.makeText(this, "You must agree to the terms and conditions", Toast.LENGTH_SHORT).show()
            return
        }

        val selectedGender: RadioButton = findViewById(selectedGenderId)
        val intent = Intent(this, DashboardActivity::class.java)
        intent.putExtra("fullName", fullName)
        intent.putExtra("email", email)
        intent.putExtra("password", password)
        intent.putExtra("country", country)
        intent.putExtra("city", city)
        intent.putExtra("gender", selectedGender.text.toString())
        startActivity(intent)
        finish()
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        // Handle item selection
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        // Handle no item selected
    }

}