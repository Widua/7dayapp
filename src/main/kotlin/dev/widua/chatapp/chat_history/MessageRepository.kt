package dev.widua.chatapp.chat_history

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository : CrudRepository<MessageHistory, String> {
    fun id(id: String): MutableList<MessageHistory>
}