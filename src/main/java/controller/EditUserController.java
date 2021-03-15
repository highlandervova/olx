package controller;

import data.User;
import enums.RedirectPath;
import enums.RequestParameter;
import enums.SessionAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("editUser")
public class EditUserController {

    private final UserService userService;

    public EditUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView editUserGet() {
        ModelAndView out = new ModelAndView("editUser");
        out.addObject("title", "Edit User Account");
        return out;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView editUserPost(HttpServletRequest req, HttpServletResponse resp) {
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
        int status;

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute(SessionAttribute.AUTHENTICATED.getValue());
        User newUser;


        if (!pass1.equals("") && pass1.equals(pass2)) {
            if (!curPass.equals("") && userService.checkUserPassword(user, curPass)) {
                newUser = new User(user.getId(), login, pass1, city, phone, email, user.getAds());
                if (userService.updateUser(newUser)) {
                    req.getSession().setAttribute(SessionAttribute.AUTHENTICATED.getValue(), newUser);
                    status = 1;
                    out.addObject("status", status);
                    return out;
                }
            }
            status = -1;
        } else {
            status = -2;
        }
        if (pass1.equals("") && pass2.equals("") && curPass.equals("")) {
            newUser = new User(user.getId(), login, user.getPass(), city, phone, email, user.getAds());
            if (userService.updateUser(newUser)) {
                req.getSession().setAttribute(SessionAttribute.AUTHENTICATED.getValue(), newUser);
                status = 1;
                out.addObject("status", status);
                return out;
            }
        }
        out.addObject("status", status);
        return out;
    }

}
