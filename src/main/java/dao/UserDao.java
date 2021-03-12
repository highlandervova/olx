package dao;

import data.Ad;
import data.User;

import java.util.Collection;

public interface UserDao {

    User getByLogin(String login) ;
    boolean add(User u);
    public boolean updateUser(User u ); //update fields pass,city,phone,email
    public void getByLoginUser(String login); // check  - true, if not user
}

