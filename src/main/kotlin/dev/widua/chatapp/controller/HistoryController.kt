package dev.widua.chatapp.controller

import dev.widua.chatapp.chat.OutputMessage
import dev.widua.chatapp.chat_history.MessageHistoryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/history")
class HistoryController(val historyService: MessageHistoryService) {

    @GetMapping("/getMessages")
    fun getHistory(): List<OutputMessage>{
        return historyService.getMessages();
    }

}