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

    public List<Message> getAll() {
        return (List<Message>) messageRepository.getAll();
    }

    public Optional<Message> getMessage(int id) {
        return messageRepository.getMessage(id);
    }

    public Message save(Message m) {
        if (m.getIdMessage() == null) {
            return messageRepository.save(m);
        } else {
            Optional<Message> e = messageRepository.getMessage(m.getIdMessage());
            if (e.isPresent()) {
                return m;
            } else {
                return messageRepository.save(m);
            }
        }
    }

    public Message update(Message m) {
        if (m.getIdMessage() != null) {
            Optional<Message> w= messageRepository.getMessage(m.getIdMessage());
            if (!w.isPresent()) {
                if (m.getMessageText() != null) {
                    w.get().setMessageText(m.getMessageText());
                }
                if (m.getIdMessage() != null) {
                    w.get().setIdMessage(m.getIdMessage());

                }
                if(m.getCostumes()!=null){
                    w.get().setCostumes(m.getCostumes());
                }
                if(m.getClients()!=null){
                    w.get().setClients(m.getClients());
                }





                return messageRepository.save(w.get());

            }
        }
        return m;

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
