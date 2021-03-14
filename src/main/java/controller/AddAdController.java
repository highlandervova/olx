package controller;

import data.Ad;
import data.User;
import enums.RequestParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.AdService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
@RequestMapping("/ad")
public class AddAdController {
    private final AdService adService;

    public AddAdController(AdService adService) {
        this.adService = adService;
    }

    @GetMapping
    public ModelAndView getView() {
        ModelAndView out = new ModelAndView("addAd");
        out.addObject("title", "Adding OLX ad");
        return out;
    }

    @PostMapping
    public void addAd(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession httpSession = req.getSession(false);
        User userFromSession = null;
        if (httpSession != null) {
            userFromSession = (User) httpSession.getAttribute(AUTHENTICATED.getValue());
        }
        if (userFromSession != null) {
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
            adService.add(ad);
        }
        resp.sendRedirect("ad");
    }
}
