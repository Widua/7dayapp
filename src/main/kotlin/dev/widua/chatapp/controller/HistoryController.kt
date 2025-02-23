package dev.widua.chatapp.controller

import dev.widua.chatapp.chat_history.MessageHistoryService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("/history")
class HistoryController(val historyService: MessageHistoryService) {

    @GetMapping("/getMessages")
    fun getHistory(model: Model, @RequestParam username: String): String {
        model.addAttribute("messages", historyService.getMessages())
        model.addAttribute("username", username)
        return "fragments/messages"
    }

}