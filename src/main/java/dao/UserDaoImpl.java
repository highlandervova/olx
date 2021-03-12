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
        s.beginTransaction();
        User u = (User) s.createQuery("FROM User WHERE login=\'" + login + "\'").uniqueResult();
        s.close();
        return u;
    }

    @Override
    public void getByLoginUser(String login) { // проверка на существоание - true, если нет user
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.createQuery("FROM User WHERE login=\'" + login + "\'").list().isEmpty();
        s.close();
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
           Query query = s.createQuery("UPDATE User set pass=\'" +u.getPass() + "\', city=\'" + u.getCity() + "\', phone=\'"+u.getPhone()+"\', email=\'"+u.getEmail()+"\' WHERE login=\'" + u.getLogin() + "\'");
           query.executeUpdate();
           s.getTransaction().commit();
           s.close();
           return true;
    }
}

