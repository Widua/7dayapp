package dev.widua.chatapp.chat_history

import dev.widua.chatapp.chat.OutputMessage


interface MessageHistoryService {
    fun getMessages(): List<OutputMessage>
    fun saveMessage(message: OutputMessage)
}