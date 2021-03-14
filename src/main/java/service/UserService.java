package service;

import dao.UserDao;
import data.User;

import org.springframework.stereotype.Service;
import java.util.UUID;


@Service
public class UserService {

    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void addNewUser(String login, String pass, String city, String phone, String email) {

        User u =
                new User(UUID.randomUUID().toString(), login, pass, city, phone, email, "");

        //return userDao.add(u) ? u : null;
        userDao.add(u);
    }
    public User getByUser(String login) {
         User u = userDao.getByLogin(login);
         return u;
    }

    public boolean checkUserPassword(User u, String pass) {

        return u != null && u.getPass().equals(pass);
    }
}
