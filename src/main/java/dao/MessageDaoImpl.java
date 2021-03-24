package dao;

import data.Message;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.LinkedList;

@Component
public class MessageDaoImpl implements MessageDao{
    @Override
    public void add(Message m) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.save(m);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Collection<Message> getByAdId(String adId) {
        Session s = HibernateUtil.getSession();
        Collection<Message> out = s.createQuery(String.format("FROM Message WHERE adId='%s'", adId)).list();
        s.close();
        return out;
    }

    @Override
    public Collection<Message> getByAdIdAndUserId(String adId, String userId) {
        Session s = HibernateUtil.getSession();
        Collection<Message> out = s.createQuery(String.format("FROM Message WHERE adId='%s' AND toUserId='%s'", adId, userId)).list();
        if (out == null) {
            out = new LinkedList<>();
        }
        out.addAll(s.createQuery(String.format("FROM Message WHERE adId='%s' AND fromUserId='%s'", adId, userId)).list());
        s.close();
        return out;
    }
}
