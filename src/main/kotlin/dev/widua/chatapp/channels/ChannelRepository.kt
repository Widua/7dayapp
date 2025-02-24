package dev.widua.chatapp.channels

import dev.widua.chatapp.chat.Channel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ChannelRepository : CrudRepository<Channel, String> {
    fun findChannelById(id: String): MutableList<Channel>
}