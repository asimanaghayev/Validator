package com.asiman.validatorexample

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.asiman.validator.Validatable
import com.asiman.validator.Validator

class CustomEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatEditText(context, attrs, defStyleAttr), Validatable {

    /**
     * Custom Edit text is valid if text is entered
     * */
    override val isValid: Boolean
        get() = length() > 0

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
}