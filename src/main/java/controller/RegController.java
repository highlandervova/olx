package controller;



import dao.UserDao;
import enums.EditUserStatus;
import enums.RedirectPath;
import enums.RequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.CityService;
import service.UserService;
import service.ValidationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
@RequestMapping("reg")
public class RegController {

    private final UserDao userDao;
    private ValidationService validationService;
    private final UserService userService;
    private final CityService cityService;

    @Autowired
    public RegController(
            final   UserService userService,
            final UserDao userDao,
            ValidationService validationService,
            CityService cityService

    ) {
        super();
        this.userDao = userDao;
        this.validationService = validationService;
        this.userService = userService;
        this.cityService = cityService;
    }




    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView regGet(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView out = new ModelAndView("reg");
        out.addObject("title", "reg page");
        out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
        out.addObject("adCity", cityService.getCities());
        return out;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView out = new ModelAndView("reg");
        out.addObject("title", "reg page");

        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String pass1 = req.getParameter(RequestParameter.PASS1.getValue());
        String pass2 = req.getParameter(RequestParameter.PASS2.getValue());
        String city = req.getParameter(RequestParameter.CITY.getValue());
        String phone = req.getParameter(RequestParameter.PHONE.getValue());
        String email = req.getParameter(RequestParameter.EMAIL.getValue());

        if (validationService.validateRegistration(login, pass1, pass2)) {
               userService.addNewUser(login, pass1, city, phone, email);
            req.getSession().setAttribute(AUTHENTICATED.getValue(), userService.getByLogin(login));
            resp.sendRedirect(RedirectPath.MAIN_REDIRECT.getValue());
            }
        EditUserStatus status = EditUserStatus.PASSWORD_FIELDS_MISMATCH;
        out.addObject("status", status.getValue());
        out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
        out.addObject("adCity", cityService.getCities());
        return out;
    }

}









