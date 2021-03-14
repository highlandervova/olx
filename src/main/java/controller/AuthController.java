package controller;


import dao.UserDao;
import data.User;
import enums.RedirectPath;
import enums.RequestParameter;
import enums.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.ValidationService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static enums.SessionAttribute.AUTHENTICATED;
import static org.springframework.web.bind.annotation.SessionAttribute.*;

@Controller
@RequestMapping("auth")
public class AuthController {

    private final UserDao userDao;
    private ValidationService validationService;
    private final UserService userService;


    @Autowired
    public AuthController(
            final   UserService userService,
            final UserDao userDao,
            ValidationService validationService

    ) {
        super();
        this.userDao = userDao;
        this.validationService = validationService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView regGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelAndView out = new ModelAndView("auth");
        out.addObject("title", "authorization page");
        String pathMain = RedirectPath.MAIN_PAGE.getValue();
        out.addObject("pathMain", pathMain);
        String pathAuth = RedirectPath.LOGIN_PAGE.getValue();
        out.addObject("pathAuth", pathAuth);
        // Title.AUTHENTICATION.getValue();
        //  out.addObject("user", userDao.add());


        return out;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelAndView out2 = new ModelAndView("auth");
        out2.addObject("title", "auth page");

        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String pass = req.getParameter(RequestParameter.PASS.getValue());
        String pathResult = RedirectPath.REG_PAGE.getValue();

        if (validationService.validateAuthentication(login, pass)) {
            req.getSession().setAttribute(AUTHENTICATED.getValue(), userService.getByLogin(login));
            pathResult = RedirectPath.MAIN_PAGE.getValue();
            } else { pathResult = RedirectPath.LOGIN_PAGE.getValue();}
            out2.addObject("pathResult", pathResult);
        return out2;
    }

}









