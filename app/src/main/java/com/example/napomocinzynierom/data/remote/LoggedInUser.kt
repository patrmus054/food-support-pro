package com.example.napomocinzynierom.data.remote

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
data class LoggedInUser(
    val userId: String?,
    val displayName: String
)
