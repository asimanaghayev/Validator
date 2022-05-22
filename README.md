# Validator
A simple library to cleanly validate on-screen input views. You can update your destination view(for ex: enable/disable button to continue) in the result of validation.

Demo
---

![Demo](./art/Validator Demo.gif)

### Setup

##### Gradle
```groovy
repositories {
  mavenCentral()
}

dependencies {
  implementation 'com.github.asimanaghayev:Validator:0.1.0'
}
```

### Usage

## Input Field
You have implement `Validatable` interface in your input field. 2 methods will be implemented in this view

**Validity State of View**
```kotlin
/**
 * Input field is valid if text is entered
 * */
override val isValid: Boolean
    get() = length() > 0
```

**Informing Validator about change in input field**
```kotlin
    override fun setupValidationListener(validator: Validator?) {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            /**
             * To inform Validator view is changed
             * */
            override fun afterTextChanged(p0: Editable?) {
                validator?.checkAll()
            }
        })
    }
```


## Output View
For output field you have to implement `Verifier` interface.

**Updating Output on validity change**
```kotlin
/**
 *  Enabling button if validator informs that all inputs are valid
 */
override fun onValid(isValid: Boolean) {
    isEnabled = isValid
} 
```

## Binding Validator views and Verifier
You have add this line to your activity/fragment for validation binding
First variable is your Verifier view then you can add all of your Validatable views, there is no Validatable view limit

**Binding**
```kotlin
ValidationBinder.bind(bindind.btnContinue, bindind.inputFirst, bindind.inputSecond)
```

