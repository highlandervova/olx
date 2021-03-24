package service;

import dao.AdDao;
import dao.UserDao;
import data.Ad;
import data.User;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.UUID;


@Service
public class UserService {

    private final UserDao userDao;
    private AdDao adDao;

    public UserService(UserDao userDao,
                       AdDao adDao) {
        this.userDao = userDao;
        this.adDao   = adDao;
    }

    public void addNewUser(String login, String pass, String city, String phone, String email) {

        User u =
                new User(UUID.randomUUID().toString(), login, pass, city, phone, email, "");


        userDao.add(u);
    }
    public User getByLogin(String login) {
         User u = userDao.getByLogin(login);
         return u;
    }

    public Collection<User> getByUsersFromAds(){  //only Users from have Ads
        Collection<User> allUser = userDao.getUsers();
        Collection<String> inUser = new LinkedHashSet<>();
        Collection<Ad> inUserfromAd = adDao.get();
        Collection<User> out = new ArrayList<>();
        for (Ad u: inUserfromAd) {
            inUser.add(u.getUserId());
        }
        for (User allu: allUser) {
            for (String uHash : inUser) {
                if (uHash.equals(allu.getId())) {
                    out.add(allu);
                }
            }
        }
         return out;
    }


    public boolean checkUserPassword(User u, String pass) {
        return u != null && u.getPass().equals(pass);
    }

    public boolean updateUser(User user){
        if (user!=null){
            userDao.updateUser(user);
            return true;
        }
        return false;
    }

    public boolean updateUserWithPassword(User user){
        if (user!=null){
            userDao.updateUserPassword(user);
            return true;
        }
        return false;
    }
}
