package com.codelytical.easyformvalidator

import android.util.Patterns

object FormValidator {
	const val DEFAULT_ERROR_MESSAGE = "Invalid input"

	/**
	 * Validates the email format.
	 *
	 * @param email The email to be validated.
	 * @return ValidationResult object indicating the validation result.
	 */
	fun isValidEmail(email: String): ValidationResult {
		return if (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			ValidationResult(success = true)
		} else {
			ValidationResult(success = false, errorMessage = "Invalid email format")
		}
	}

	/**
	 * Validates the phone number format.
	 *
	 * @param phoneNumber The phone number to be validated.
	 * @return ValidationResult object indicating the validation result.
	 */
	fun isValidPhoneNumber(phoneNumber: String): ValidationResult {
		val regex = "^[+]?[0-9]{10,13}$"
		return if (phoneNumber.isNotEmpty() && phoneNumber.matches(regex.toRegex())) {
			ValidationResult(success = true)
		} else {
			ValidationResult(success = false, errorMessage = "Invalid phone number format")
		}
	}

	/**
	 * Validates the strength of the password.
	 *
	 * @param password The password to be validated.
	 * @return ValidationResult object indicating the validation result.
	 */
	fun isStrongPassword(password: String): ValidationResult {
		val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
		return if (password.isNotEmpty() && password.matches(regex.toRegex())) {
			ValidationResult(success = true)
		} else {
			ValidationResult(success = false, errorMessage = "Weak password")
		}
	}

	/**
	 * Validates that the value is not empty.
	 *
	 * @param value The value to be validated.
	 * @return ValidationResult object indicating the validation result.
	 */
	fun isNotEmpty(value: String): ValidationResult {
		return if (value.isNotEmpty()) {
			ValidationResult(success = true)
		} else {
			ValidationResult(success = false, errorMessage = "Field is required")
		}
	}
}
