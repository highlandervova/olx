package controller;

import data.Ad;
import data.User;
import enums.EditUserStatus;
import enums.RedirectPath;
import enums.RequestParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdService;
import service.CityService;
import service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
@RequestMapping("/addAd")
public class AddAdController {
    private final AdService adService;
    private final CityService cityService;
    private UserService userService;

    public AddAdController(
            AdService adService,
            final CityService cityService,
            UserService userService) {

        this.cityService = cityService;
        this.adService = adService;
        this.userService = userService;
    }

    @GetMapping
    public ModelAndView getView(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView out = new ModelAndView("addAd");
        out.addObject("title", "Adding OLX ad");
        out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
        out.addObject("adCity", cityService.getCities());
        User user = (User) req.getSession().getAttribute(AUTHENTICATED.getValue());
        String cityUserId = user.getCity();
        out.addObject("cityUser", cityUserId);
        out.addObject("phoneUser",user.getPhone() );
        out.addObject("emailUser",user.getEmail() );
        out.addObject("otherCities", cityService.getOtherCities(cityUserId));
        return out;
    }

    @PostMapping
    public ModelAndView postGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ModelAndView out = new ModelAndView("addAd");
        out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
        HttpSession httpSession = req.getSession(false);
        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        if (httpSession != null) {

            Ad ad = new Ad();
            ad.setName(req.getParameter(RequestParameter.NAME.getValue()));
            ad.setDescr(req.getParameter(RequestParameter.DESCR.getValue()));
            ad.setPic(req.getParameter(RequestParameter.PIC.getValue()));
            ad.setPrice(Integer.parseInt(req.getParameter(RequestParameter.PRICE.getValue())));
            ad.setUserId(userFromSession.getId());
            ad.setCity(req.getParameter(RequestParameter.CITY.getValue()));
            ad.setPhone(req.getParameter(RequestParameter.PHONE.getValue()));
            ad.setEmail(req.getParameter(RequestParameter.EMAIL.getValue()));
            ad.setRubric(Integer.parseInt(req.getParameter(RequestParameter.RUBRIC.getValue())));
            ad.setDate(new Date());
            adService.add(ad);
            EditUserStatus status = EditUserStatus.CHANGES_SAVED;
            out.addObject("status", status.getValue());
            out.addObject("otherCities", cityService.getCities());
            return out;
        }
        resp.sendRedirect(RedirectPath.MAIN_PAGE.getValue());
        return out;
    }



}
