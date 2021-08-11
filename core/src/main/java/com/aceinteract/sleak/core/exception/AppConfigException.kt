package com.aceinteract.sleak.core.exception

/**
 * Exception thrown when an error occurs with the local app config data is made.
 */
class AppConfigException(
    override val messageResId: Int,
    override val cause: Throwable? = null
) : AppException(messageResId)
