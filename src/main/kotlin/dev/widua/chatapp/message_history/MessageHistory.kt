package dev.widua.chatapp.message_history

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Message")
data class MessageHistory(@Id var id: String, var username: String, var message: String, var time: String)
