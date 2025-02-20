package dev.widua.chatapp.chat

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    var username: String,
    var message: String
)