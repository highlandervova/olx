package dao;

import data.User;
import hibernate.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.Statement;

@Component
public class UserDaoImpl implements UserDao {

    @Override
    public User getByLogin(String login) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        User u = (User) s.createQuery("FROM User WHERE login=\'" + login + "\'").list().get(0);
        s.close();
        return u;
    }

    public boolean getByLoginUser(String login) { // проверка на существоание - true, если нет user
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        return s.createQuery("FROM User WHERE login=\'" + login + "\'").list().isEmpty();
    }


    @Override
    public boolean add(User u) {
        if (getByLoginUser(u.getLogin())) {
            Session s = HibernateUtil.getSession();
            s.beginTransaction();
            s.save(u);
            s.getTransaction().commit();
            s.close();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean updateUser(User u ) {
        if (getByLoginUser(u.getLogin())) {
            Session s = HibernateUtil.getSession();
            s.beginTransaction();
           Query query = s.createQuery("UPDATE User set pass=\'" +u.getPass() + "\', city=\'" + u.getCity() + "\', phone=\'"+u.getPhone()+"\', email=\'"+u.getEmail()+"\' WHERE login=\'" + u.getLogin() + "\'");
           query.executeUpdate();
           s.getTransaction().commit();
            s.close();

         return true;
        } else {
            return false;
        }
    }



}

