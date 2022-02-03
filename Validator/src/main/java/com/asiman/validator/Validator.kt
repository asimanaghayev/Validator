package com.asiman.validator

/**
 * This Interface is used for checking all [Validatable] views. <br></br>
 * It has single implementation in [ValidationBinder]. <br></br>
 * All the [Validatable] views uses this interface for triggering [Validator.checkAll].
 *
 * @author Asiman Aghayev
 * @see ValidationBinder
 *
 * @since 01-11-2021
 */
interface Validator {
    /**
     * This method checks all available [Validatable] views.
     */
    fun checkAll()
}