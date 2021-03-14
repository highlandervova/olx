package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    @Autowired
    private UserDao userDao;


    public boolean validateRegistration(String login, String pass1, String pass2) {
        //if (pass1 != null && pass1.equals(pass2) && login != null) {
            if (userDao.getByLogin(login) == null) {   //  if (userDao.getByLogin(login) == null) {

                return (pass1 != null && pass1.equals(pass2) && login != null);
            }
            return false;
    }
}
