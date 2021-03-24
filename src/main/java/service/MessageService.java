package service;

import dao.MessageDao;
import data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.UUID;

@Service
public class MessageService {
    @Autowired
    private MessageDao messageDao;

    public void addMessage(String message, String fromUserId, String toUserId, String adId) {
        this.add(new Message(UUID.randomUUID().toString(), message, fromUserId, toUserId, adId, new Date(System.currentTimeMillis())));
    }

    private void add(Message m) {
        messageDao.add(m);
    }
    public Collection<Message> getByAdId(String adId) {
        return messageDao.getByAdId(adId);
    }

    public Collection<Message> getByAdIdAndUserId(String adId, String userId) {
        return messageDao.getByAdIdAndUserId(adId, userId);
    }
}
