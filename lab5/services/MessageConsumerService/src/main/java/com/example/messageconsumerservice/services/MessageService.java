package com.example.messageconsumerservice.services;

import com.example.messageconsumerservice.entities.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {
    void saveMessage(Message message);

    Message getMessageById(Long id);

    List<Message> getAllMessages();
}