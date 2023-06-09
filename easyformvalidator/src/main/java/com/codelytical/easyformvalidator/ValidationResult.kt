package com.codelytical.easyformvalidator

data class ValidationResult(val success: Boolean, val errorMessage: String = FormValidator.DEFAULT_ERROR_MESSAGE)
