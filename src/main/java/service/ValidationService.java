package service;

import dao.UserDao;
import data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {


    @Autowired
    private UserService userService;


    public boolean validateRegistration(String login, String pass1, String pass2) {

        if (userService.getByLogin(login) == null) {

            return (pass1 != null && pass1.equals(pass2) && login != null);
        }
        return false;
    }


    public boolean validateAuthentication(String login, String pass) {
        User u = userService.getByLogin(login);
        if ( u!= null){
            return userService.checkUserPassword(u, pass);
        } return false;
    }
}