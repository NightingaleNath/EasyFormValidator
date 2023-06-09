# **EasyFormValidator**

[![](https://jitpack.io/v/NightingaleNath/EasyFormValidator.svg)](https://jitpack.io/#NightingaleNath/EasyFormValidator)

EasyFormValidator is a powerful library that simplifies form input validation for Android developers. With a comprehensive set of validation rules and utilities, you can easily validate form fields such as email, phone number, password strength, and more.

Integration
To integrate the EasyFormValidator library into your Android project, follow these steps:

Step 1. Add the JitPack repository to your build file

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Step 2. Add the dependency

```
dependencies {
	        implementation 'com.github.NightingaleNath:EasyFormValidator:<latest-version>'
	}
```

3. Sync your project with the Gradle files to download the EasyFormValidator library.

**Usage**
Once you have integrated the EasyFormValidator library into your project, you can start using it to validate form fields. Follow the example below to see how it works:

```
import com.example.easyformvalidator.FormValidator
import com.example.easyformvalidator.ValidationResult

// Example usage
val email = "test@example.com"
val phoneNumber = "+1234567890"
val password = "Password123"

val emailValidationResult: ValidationResult = FormValidator.isValidEmail(email)
if (!emailValidationResult.success) {
    // Handle email validation failure
    val errorMessage: String = emailValidationResult.errorMessage
    // Display error message to the user or take appropriate action
}

val phoneValidationResult: ValidationResult = FormValidator.isValidPhoneNumber(phoneNumber)
if (!phoneValidationResult.success) {
    // Handle phone number validation failure
    val errorMessage: String = phoneValidationResult.errorMessage
    // Display error message to the user or take appropriate action
}

val passwordValidationResult: ValidationResult = FormValidator.isStrongPassword(password)
if (!passwordValidationResult.success) {
    // Handle password validation failure
    val errorMessage: String = passwordValidationResult.errorMessage
    // Display error message to the user or take appropriate action
}

// If all validations pass, proceed with form submission
// Your logic for form submission here
```

In the code snippet above, we demonstrate the usage of EasyFormValidator to validate email, phone number, and password fields. Each validation function returns a ValidationResult object, which indicates the success status and provides an error message if validation fails. You can handle validation failures by retrieving the error message and displaying it to the user or taking appropriate action.

Make sure to replace com.example.easyformvalidator with your chosen package name in the import statements.

