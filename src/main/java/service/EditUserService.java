package service;

import data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUserService {

    @Autowired
    UserService userService;

    public int checkPasswordFields(User curUser, String enteredCurPass, String pass1, String pass2) {
        if (!enteredCurPass.equals("")) {
            if (!pass1.equals("") && pass1.equals(pass2)) { //New entered passwords match)
                if (userService.checkUserPassword(curUser, enteredCurPass)) {
                    return 1;
                }
                return -1;
            }
            if (pass1.equals("")) {
                if (userService.checkUserPassword(curUser, enteredCurPass)) {
                    return 2;
                }
                return -1;
            }
            return -2;
        }
        return -3;

    }

    public boolean editUser(User curUser, User editedUser, int updateType) {
        switch (updateType) {
            case 1:
                return userService.updateUserWithPassword(new User(curUser.getId(), editedUser.getLogin(), editedUser.getPass(), editedUser.getCity(), editedUser.getPhone(), editedUser.getEmail(), curUser.getAds()));
            case 2:
                return userService.updateUser(new User(curUser.getId(), editedUser.getLogin(), curUser.getPass(), editedUser.getCity(), editedUser.getPhone(), editedUser.getEmail(), curUser.getAds()));
            default:
                return false;
        }
    }
}
