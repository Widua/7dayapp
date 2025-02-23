package dev.widua.chatapp.chat

import dev.widua.chatapp.chat_history.MessageHistoryService
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.springframework.stereotype.Component
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.TextWebSocketHandler
import java.text.SimpleDateFormat
import java.util.*

@Component
class WebsocketHandler(val messageHistoryService: MessageHistoryService) : TextWebSocketHandler() {
    private val sessions = mutableListOf<WebSocketSession>()


    override fun afterConnectionEstablished(session: WebSocketSession) {
        println("Connection established: " + session.remoteAddress)
        sessions.add(session)
    }

    override fun handleTextMessage(session: WebSocketSession, message: TextMessage) {
        val receivedMessage = message.payload

        val json = Json{
            ignoreUnknownKeys = true
        }

        val messageObject = json.decodeFromString<Message>( receivedMessage )
        val outputMessage = OutputMessage( messageObject.username, messageObject.message, SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
            Date()
        ) )
        messageHistoryService.saveMessage(outputMessage)
        for (session in sessions){
            session.sendMessage(TextMessage( Json.encodeToString(outputMessage) ))
        }
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        sessions.remove(session);
    }
}