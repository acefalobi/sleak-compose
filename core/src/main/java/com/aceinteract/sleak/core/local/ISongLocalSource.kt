package com.aceinteract.sleak.core.local

import com.aceinteract.sleak.core.model.Song
import kotlinx.coroutines.flow.Flow

/**
 * Interface for accessing local song sources.
 */
interface ISongLocalSource {
    /**
     * Get all songs in user's library.
     *
     * @return the flow of songs.
     */
    fun getSongs(): Flow<List<Song>>
}
