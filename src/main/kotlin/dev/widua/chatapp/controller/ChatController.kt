package dev.widua.chatapp.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping


@Controller
class ChatController {

    @GetMapping("/")
    fun home(model: Model): String{
        return "index";
    }

}
