package com.prayag.web;

import com.prayag.domain.ChatMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.messaging.simp.SimpMessagingTemplate;


@RestController
public class AppController {

    private final SimpMessagingTemplate messagingTemplate;

    public AppController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping("/notify/{note}")
    public String sendAlertNote(@PathVariable String note){

        ChatMessage cm = new ChatMessage();
        cm.setContent(note);
        messagingTemplate.convertAndSend("/topic/messages",cm);
        return "Sent!";

    }


}
