package com.asiman.validatorexample

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.asiman.validator.Verifier

class CustomButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : AppCompatButton(context, attrs, defStyleAttr), Verifier {

    /**
     *  Enabling button if validator informs that all inputs are valid
     */
    override fun onValid(isValid: Boolean) {
        isEnabled = isValid
    }
}