package dev.widua.chatapp.message_history

import dev.widua.chatapp.chat.OutputMessage
import org.springframework.stereotype.Service

@Service
class MessageHistoryServiceImpl(val repository: MessageRepository) : MessageHistoryService {

    override fun getMessages(): List<OutputMessage> {
        return repository.findAll().map {
            history -> OutputMessage(history.username, history.message,history.time)
        }.toList();
    }

    override fun saveMessage(message: OutputMessage) {
        repository.save( MessageHistory( (message.time+message.username), message.username, message.message, message.time ) );
    }
}