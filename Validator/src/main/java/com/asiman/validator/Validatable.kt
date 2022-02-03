package com.asiman.validator

/**
 * This Interface is used for views which should be validated. <br></br>
 *
 * @author Asiman Aghayev
 * @see ValidationBinder
 *
 * @since 01-11-2021
 */
interface Validatable {
    /**
     * This method is used to setup the listener for triggering validation process for views.
     *
     * @param validator passes the interface for checking all of the views.
     */
    fun setupValidationListener(validator: Validator?)

    /**
     * This method indicates if the view is valid or not.
     *
     * @return true for valid, false for not valid
     */
    val isValid: Boolean
}