package service;

import data.User;
import enums.EditUserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditUserService {

    @Autowired
    UserService userService;

    public EditUserStatus checkPasswordFields(User curUser, String enteredCurPass, String pass1, String pass2) {
        if (!enteredCurPass.equals("")) {
            if (!pass1.equals("") && pass1.equals(pass2)) { //New entered passwords match)
                if (userService.checkUserPassword(curUser, enteredCurPass)) {
                    return EditUserStatus.CHANGES_WITH_PASSWORD_OK;
                }
                return EditUserStatus.PASSWORD_INCORRECT;
            }
            if (pass1.equals("") && pass2.equals("")) {
                if (userService.checkUserPassword(curUser, enteredCurPass)) {
                    return EditUserStatus.CHANGES_SAVED;
                }
                return EditUserStatus.PASSWORD_INCORRECT;
            }
            return EditUserStatus.PASSWORD_FIELDS_MISMATCH;
        }
        return EditUserStatus.ENTER_PASSWORD;

    }

    public boolean editUser(User curUser, User editedUser, EditUserStatus updateType) {
        switch (updateType) {
            case CHANGES_WITH_PASSWORD_OK:
                return userService.updateUserWithPassword(new User(curUser.getId(), editedUser.getLogin(), editedUser.getPass(), editedUser.getCity(), editedUser.getPhone(), editedUser.getEmail(), curUser.getAds()));
            case CHANGES_SAVED:
                return userService.updateUser(new User(curUser.getId(), editedUser.getLogin(), curUser.getPass(), editedUser.getCity(), editedUser.getPhone(), editedUser.getEmail(), curUser.getAds()));
            default:
                return false;
        }
    }
}
