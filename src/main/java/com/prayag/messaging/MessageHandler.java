package com.prayag.messaging;

import com.prayag.domain.ChatMessage;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@Slf4j
public class MessageHandler {

    private static final Logger log = LoggerFactory.getLogger(MessageHandler.class);

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public ChatMessage send(ChatMessage message){
        log.info("Received message: {}, from {}",message.getFrom(),message.getContent());
        message.setContent("Sent through springboot websocket");
        return message;
    }

}
