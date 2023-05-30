package com.example.messageconsumerservice.controllers;

import com.example.messageconsumerservice.entities.Message;
import com.example.messageconsumerservice.services.MessageService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableRabbit
public class RabbitMQHandler {
    @Autowired
    private MessageService messageService;

    @RabbitListener(queues = {"user-queue"})
    public void handleMessage(String message) {
        var msg = new Message();
        msg.setMessageText(message);
        msg.setMessageDate(Instant.now());
        messageService.saveMessage(msg);
    }
}
