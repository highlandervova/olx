package dao;

import data.User;

import java.util.Collection;

public interface UserDao {

    User getByLogin(String login) ;
    boolean add(User u);
    boolean updateUser(User u ); //update fields login,city,phone,email
    boolean updateUserPassword(User u ); //updates all fields (login,pass,city,phone,email) except ads
    public Collection<User> getUsers();

}

