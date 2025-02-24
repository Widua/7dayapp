package dev.widua.chatapp.chat

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("channel")
data class Channel(@Id val id: String, val name: String)
