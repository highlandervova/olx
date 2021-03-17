package controller;

import data.User;
import enums.EditUserStatus;
import enums.RedirectPath;
import enums.RequestParameter;
import enums.SessionAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.EditUserService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("editUser")
public class EditUserController {

    private final UserService userService;
    private final EditUserService editUserService;

    public EditUserController(UserService userService, EditUserService editUserService) {
        this.userService = userService;
        this.editUserService = editUserService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editUserGet() {
        ModelAndView out = new ModelAndView("editUser");
        out.addObject("title", "Edit User Account");
        return out;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editUserPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView out = new ModelAndView("editUser");
        out.addObject("title", "Edit User Account");
        String pathMain = RedirectPath.MAIN_PAGE.getValue();
        out.addObject("pathMain", pathMain);
        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String curPass = req.getParameter("curPass");
        String pass1 = req.getParameter(RequestParameter.PASS1.getValue());
        String pass2 = req.getParameter(RequestParameter.PASS2.getValue());
        String city = req.getParameter(RequestParameter.CITY.getValue());
        String phone = req.getParameter(RequestParameter.PHONE.getValue());
        String email = req.getParameter(RequestParameter.EMAIL.getValue());

        HttpSession session = req.getSession(false);
        if (session != null) {
            User user = (User) session.getAttribute(SessionAttribute.AUTHENTICATED.getValue());

            User editedUser = new User(user.getId(), login, pass1, city, phone, email, user.getAds());

            EditUserStatus status = editUserService.checkPasswordFields(user, curPass, pass1, pass2);
            if (editUserService.editUser(user, editedUser, status)) {
                if (status.equals(EditUserStatus.CHANGES_SAVED)) { //that's basically hack to update authorized User in session without query to DB
                    editedUser.setPass(user.getPass());
                }
                req.getSession().setAttribute(SessionAttribute.AUTHENTICATED.getValue(), editedUser);
            }
            out.addObject("status", status.getValue());
            return out;
        } else {
            resp.sendRedirect(RedirectPath.LOGIN_PAGE.getValue());
        }
        return out;
    }
}
