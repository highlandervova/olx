package dao;

import data.Message;

import java.util.Collection;

public interface MessageDao {
    void add(Message m);
    Collection<Message> getByAdId(String adId);
    Collection<Message> getByAdIdAndUserId(String adId, String userId);
}
