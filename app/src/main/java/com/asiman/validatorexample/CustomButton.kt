package com.asiman.validatorexample

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.asiman.validator.Verifier

class CustomButton : AppCompatButton, Verifier {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context,
        attrs,
        defStyleAttr)

    override fun onValid(isValid: Boolean) {
        // Enabling button if validator informs that all inputs are valid
        isEnabled = isValid
    }
}