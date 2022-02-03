package com.asiman.validatorexample

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.asiman.validator.Validatable
import com.asiman.validator.Validator

class CustomEditText : AppCompatEditText, Validatable {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr)

    // Custom Edit text is valid if text is entered
    override val isValid: Boolean
        get() = length() > 0

    override fun setupValidationListener(validator: Validator?) {
        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {
                // To inform Validator view is changed
                validator?.checkAll()
            }
        })
    }

}