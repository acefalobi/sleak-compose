package com.ulesson.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

private val isoFormat get() = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'Z", Locale.getDefault())

/**
 * Convert the date object into an ISO8601 string format.
 */
fun Date.toISOString(): String = isoFormat.format(this)