package com.aceinteract.sleak.common.util

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Let a flow run on the IO thread.
 *
 * @param T the type parameter for the flow.
 * @param onEach the action to take on each iteration.
 *
 * @return the flow.
 */
fun <T> Flow<T>.flowOnIO(onEach: suspend (T) -> Unit): Flow<T> =
    flowOn(Dispatchers.IO).onEach { onEach(it) }

/**
 * Run a suspend function on the IO thread.
 *
 * @param T the return parameter of the action.
 * @param action the suspend function to invoke.
 * @param onError the action to take when an exception is encountered.
 *
 * @return the output of the suspend function [action].
 */
fun <T> CoroutineScope.runOnIO(
    action: suspend () -> T,
    onError: (Throwable) -> Unit,
) {
    launch {
        withContext(Dispatchers.IO) {
            try {
                action()
            } catch (e: Throwable) {
                onError(e)
            }
        }
    }
}