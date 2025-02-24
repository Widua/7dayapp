package dev.widua.chatapp.controller

import dev.widua.chatapp.channels.ChannelService
import dev.widua.chatapp.chat.Channel
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
class ChatController(
    private val channelService: ChannelService
) {

    @GetMapping("/")
    fun home(model: Model): String{
        return "index";
    }

    @GetMapping("/connect")
    fun connect(model: Model): String{
        return "fragments/connect";
    }

    @GetMapping("/channels")
    fun channels(model: Model): String{
        model.addAttribute("channels", channelService.getAllChannels());
        return "fragments/channels/channelSelect"
    }

    @GetMapping("/channel/create")
    fun createChannel(model: Model): String{
        return "fragments/channels/channelCreate";
    }

    @PostMapping("/channel/create")
    fun createChannel(model: Model,@RequestParam channelName: String): String{

        channelService.createChannel(Channel( UUID.randomUUID().toString(), channelName  ));
        model.addAttribute("channels", channelService.getAllChannels());
        return "fragments/channels/channelSelect";
    }



}
