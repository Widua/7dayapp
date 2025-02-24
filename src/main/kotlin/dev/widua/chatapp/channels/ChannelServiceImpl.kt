package dev.widua.chatapp.channels

import dev.widua.chatapp.chat.Channel
import org.springframework.stereotype.Service

@Service
class ChannelServiceImpl(val repository: ChannelRepository) : ChannelService {
    override fun getAllChannels(): List<Channel> {
        return repository.findAll().toList()
    }

    override fun getChannel(id: String): Channel? {
        return repository.findChannelById(id).getOrNull(0);
    }

    override fun createChannel(channel: Channel) {
        repository.save(channel);
    }
}