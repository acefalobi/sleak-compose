package com.aceinteract.sleak.core.exception

/**
 * Exception thrown when an unauthorized request is made.
 */
class UnauthorizedException(override val messageResId: Int) : AppException(messageResId)
