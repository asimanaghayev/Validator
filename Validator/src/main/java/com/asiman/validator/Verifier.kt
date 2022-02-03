package com.asiman.validator

/**
 * This Interface is used for the views which needs to take action if all the [Validatable] views are valid. <br></br>
 * [ValidationBinder] triggers it on valid state of [Validatable] views. <br></br>
 *
 * @author Asiman Aghayev
 * @see ValidationBinder
 *
 * @since 01-11-2021
 */
interface Verifier {
    /**
     * This method indicates view behavior on valid state of [Validatable].
     *
     * @param isValid true for valid, false for non valid.
     */
    fun onValid(isValid: Boolean)
}