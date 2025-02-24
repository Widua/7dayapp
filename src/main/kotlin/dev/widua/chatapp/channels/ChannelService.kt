package dev.widua.chatapp.channels

import dev.widua.chatapp.chat.Channel

interface ChannelService {
    fun getAllChannels(): List<Channel>
    fun getChannel(id: String): Channel?
    fun createChannel(channel: Channel)
}