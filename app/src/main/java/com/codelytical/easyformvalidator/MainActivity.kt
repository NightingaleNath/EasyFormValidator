package com.codelytical.easyformvalidator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val emailEditText = findViewById<EditText>(R.id.emailEditText)
		val phoneEditText = findViewById<EditText>(R.id.phoneEditText)
		val passwordEditText = findViewById<EditText>(R.id.passwordEditText)
		val submitButton = findViewById<Button>(R.id.submitButton)

		submitButton.setOnClickListener {
			val email = emailEditText.text.toString()
			val phoneNumber = phoneEditText.text.toString()
			val password = passwordEditText.text.toString()

			// Check if any field is empty
			val emailEmptyValidationResult = FormValidator.isNotEmpty(email)
			if (!emailEmptyValidationResult.success) {
				emailEditText.error = emailEmptyValidationResult.errorMessage
				return@setOnClickListener
			}

			val phoneEmptyValidationResult = FormValidator.isNotEmpty(phoneNumber)
			if (!phoneEmptyValidationResult.success) {
				phoneEditText.error = phoneEmptyValidationResult.errorMessage
				return@setOnClickListener
			}

			val passwordEmptyValidationResult = FormValidator.isNotEmpty(password)
			if (!passwordEmptyValidationResult.success) {
				passwordEditText.error = passwordEmptyValidationResult.errorMessage
				return@setOnClickListener
			}

			// Check email format
			val emailValidationResult = FormValidator.isValidEmail(email)
			if (!emailValidationResult.success) {
				emailEditText.error = emailValidationResult.errorMessage
				return@setOnClickListener
			}

			// Check phone number format
			val phoneValidationResult = FormValidator.isValidPhoneNumber(phoneNumber)
			if (!phoneValidationResult.success) {
				phoneEditText.error = phoneValidationResult.errorMessage
				return@setOnClickListener
			}

			// Check password strength
			val passwordValidationResult = FormValidator.isStrongPassword(password)
			if (!passwordValidationResult.success) {
				passwordEditText.error = passwordValidationResult.errorMessage
				return@setOnClickListener
			}

			// All validations passed, proceed with form submission
			// Your logic for form submission here

			Toast.makeText(this, "Form submitted successfully", Toast.LENGTH_SHORT).show()
		}
	}
}