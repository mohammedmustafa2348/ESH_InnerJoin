package com.example.api;

import com.example.entity.Message;

import java.util.List;

/**
 * Created by Mustafa on 9/3/2016.
 */
public class MessageDao {

    Message message;

    public List<Message> getMessage(String fromUserId, String toUserId){
        List<Message> messageList;
        return null;
    }

    public boolean addMessage(Message message){
        boolean status= true;
        return status;
    }

    public boolean deleteMessage(Message message){
        boolean status= true;
        return status;
    }
}
