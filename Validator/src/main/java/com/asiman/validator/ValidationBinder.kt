package com.asiman.validator

/**
 * This Binder class is for **validating** all certain views on screen and doing predefined task for Valid state. <br></br>
 * <br></br>
 * When [Validatable] views are updated, they triggers [Validator] and it is checking all available [Validatable] views.
 * If it detects that all [Validatable] views are valid [Validator] triggers [Verifier] and it updates the final destination view for validation.
 * <br></br>
 * <br></br>
 * To use [ValidationBinder], validation needed views should implement [Validatable]. <br></br>
 * The destination view should implement [Verifier], which will be updated on all [Validatable] views valid state. <br></br>
 * To complete the usage [Verifier] and all [Validatable] views should be passed to [ValidationBinder.bind] method.<br></br>
 * <br></br>
 * <br></br>
 * You can find the diagram of the scenario for [ValidationBinder] in bottom diagram. <br></br>
 * <pre>
 *
 * **Validatable**              **Validator**                 **Verifier**
 *
 *
 * ┏━━━━━━━━━━━━━━━━┓
 * ┃   UI Element   ┣━━━┓
 * ┗━━━━━━━━━━━━━━━━┛   ┃
 * ┏━━━━━━━━━━━━━━━━┓   ┃
 * ┃   UI Element   ┣━━━┫
 * ┗━━━━━━━━━━━━━━━━┛   ┃       ┏━━━━━━━━━━━━━━━━━━┓
 * ┏━━━━━━━━━━━━━━━━┓   ┃       ┃                  ┃        ┏━━━━━━━━━━━━┓
 * ┃   UI Element   ┣━━━╋━━━━━> ┃ ValidationBinder ┃━━━━━━> ┃   Button   ┃
 * ┗━━━━━━━━━━━━━━━━┛   ┃       ┃                  ┃        ┗━━━━━━━━━━━━┛
 * ┏━━━━━━━━━━━━━━━━┓   ┃       ┗━━━━━━━━━━━━━━━━━━┛
 * ┃   UI Element   ┣━━━┫
 * ┗━━━━━━━━━━━━━━━━┛   ┃
 * .....                ┋
 * .....                ┋
 * .....                ┋
 * ..
 * ..
</pre> *
 *
 * @author Asiman Aghayev
 * @implNote Make Sure all views are ready to be updated.
 * @see Validatable
 *
 * @see Validator
 *
 * @see Verifier
 *
 * @since 01-11-2021
 */
class ValidationBinder internal constructor(
    private val verifier: Verifier,
    private vararg val validatables: Validatable?,
) : Validator {

    companion object {
        /**
         * This method binds [Verifier] and all [Validatable] views.
         */
        fun bind(verifier: Verifier, vararg validatables: Validatable?): ValidationBinder {
            return ValidationBinder(verifier, *validatables)
        }
    }

    private fun setupValidators() {
        for (validatable in validatables) {
            validatable?.setupValidationListener(this)
        }
        checkAll()
    }

    override fun checkAll() {
        var isValid = true
        for (validatable in validatables) {
            if (validatable?.isValid == false) {
                isValid = false
                break
            }
        }
        verifier.onValid(isValid)
    }

    init {
        setupValidators()
    }
}