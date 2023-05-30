package com.example.messageconsumerservice.services;

import com.example.messageconsumerservice.entities.Message;
import com.example.messageconsumerservice.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).get();
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}