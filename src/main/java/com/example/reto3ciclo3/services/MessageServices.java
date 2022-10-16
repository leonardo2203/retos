package com.example.reto3ciclo3.services;

import com.example.reto3ciclo3.Modelo.Message;

import com.example.reto3ciclo3.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class MessageServices {
    @Autowired
    private MessageRepository messageRepository;


    public List<Message> getAll(){
        return messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }

    public Message save(Message p){
        if (p.getIdMessage()==null){
            return messageRepository.save(p);
        }else {
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if (e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }

    public Message update(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> q = messageRepository.getMessage(message.getIdMessage());
            if (!q.isPresent()) {
                if (message.getMessageText() != null) {
                    q.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    public boolean delete(int id) {
        boolean flag = false;
        Optional<Message> p = messageRepository.getMessage(id);
        if (p.isPresent()) {
            messageRepository.delete(p.get());
            flag = true;
        }
        return flag;

    }

}
