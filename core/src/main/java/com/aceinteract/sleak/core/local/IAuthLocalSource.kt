package com.aceinteract.sleak.core.local

import kotlinx.coroutines.flow.Flow

/**
 * Interface for accessing local authentication sources (keys, tokens, etc.).
 */
interface IAuthLocalSource {
    /**
     * The unique ID for the device.
     */
    var deviceUUID: String

    /**
     * The learner's authentication token.
     */
    var authToken: String?

    /**
     * The learner's Firebase Messaging token.
     */
    var fcmToken: String?

    /**
     * Log out the currently logged in learner, i.e, delete their data from the device.
     */
    suspend fun logOut()
}
