package dev.widua.chatapp.chat

import kotlinx.serialization.Serializable

@Serializable
data class OutputMessage(var username: String,var message: String,var time: String) {

}