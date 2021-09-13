package com.aceinteract.sleak.core.exception

/**
 * General exception for all errors thrown from ULesson code.
 * If you get this, you should be able to find out what's wrong pretty easily.
 *
 * @property messageResId the optional string resource id for the error.
 */
open class AppException(
    open val messageResId: Int?,
    override val message: String?,
    override val cause: Throwable?
) : Exception() {
    constructor(messageResId: Int) : this(messageResId, null, null)

    constructor(message: String) : this(null, message, null)

    constructor(messageResId: Int, cause: Throwable) : this(messageResId, null, cause)

    constructor(message: String, cause: Throwable) : this(null, message, cause)
}
