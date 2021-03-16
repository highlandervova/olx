package dao;

import data.User;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public User getByLogin(String login) {
        Session s = HibernateUtil.getSession();
        User u = (User) s.createQuery("FROM User WHERE login=\'" + login + "\'").uniqueResult();
        s.close();
        return u;
    }




    @Override
    public boolean add(User u) {
            Session s = HibernateUtil.getSession();
            s.beginTransaction();
            s.save(u);
            s.getTransaction().commit();
            s.close();
            return true;
    }

    @Override
    public boolean updateUser(User u ) {
           Session s = HibernateUtil.getSession();
           s.beginTransaction();
           Query query = s.createQuery("UPDATE User set login=\'"+u.getLogin()+ "\', city=\'" + u.getCity() + "\', phone=\'"+u.getPhone()+"\', email=\'"+u.getEmail()+"\' WHERE id=\'" + u.getId() + "\'");
           query.executeUpdate();
           s.getTransaction().commit();
           s.close();
           return true;
    }
    @Override
    public boolean updateUserPassword(User u ) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Query query = s.createQuery("UPDATE User set login=\'"+u.getLogin()+"\', pass=\'" +u.getPass() + "\', city=\'" + u.getCity() + "\', phone=\'"+u.getPhone()+"\', email=\'"+u.getEmail()+"\' WHERE id=\'" + u.getId() + "\'");
        query.executeUpdate();
        s.getTransaction().commit();
        s.close();
        return true;
    }
}

