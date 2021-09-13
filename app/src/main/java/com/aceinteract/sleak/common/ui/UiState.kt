package com.aceinteract.sleak.common.ui

/**
 * Base interface for all UI States.
 */
sealed interface UiState<T> {
    /**
     * Successfully loaded data.
     *
     * @property data the loaded data.
     */
    data class Success<T>(val data: T) : UiState<T>

    /**
     * Loading data.
     */
    class Loading<T> : UiState<T>

    /**
     * Encountered an error.
     *
     * @property error the error thrown.
     */
    data class Error<T>(val error: Throwable) : UiState<T>
}