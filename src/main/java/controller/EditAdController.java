package controller;

import data.Ad;
import data.User;
import enums.RedirectPath;
import enums.Title;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AdService;
import service.CityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
@RequestMapping("/editAd")
public class EditAdController {
    private final AdService adService;
    private final CityService cityService;

    public EditAdController(
            AdService adService,
           CityService cityService
    ) {
        this.adService = adService;
        this.cityService= cityService;
    }

    @GetMapping
    public ModelAndView getView(HttpServletResponse resp, HttpServletRequest req,
                                @RequestParam(name = "adId", required=true) String adId) throws IOException {
        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        Ad ad = adService.getById(adId);
        if (ad != null) {
            ModelAndView out = new ModelAndView("editAd");
            if (userFromSession != null && userFromSession.getId().equals(ad.getUserId())) {
                out.addObject("edit", true);
                User user = (User) req.getSession().getAttribute(AUTHENTICATED.getValue());
                String cityUserId = user.getCity();
                Integer FavorYes = ad.getFavor();
                out.addObject("FavorYes",ad.getFavor());
                out.addObject("cityUser", cityUserId);
                out.addObject("otherCities", cityService.getOtherCities(cityUserId));
            }
            out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
            out.addObject("pathEdit", RedirectPath.EDIT_AD.getValue());
            out.addObject("ad", adService.getById(adId));
            out.addObject("title", Title.EDIT_AD);
            out.addObject("adCity", cityService.getCities());
            return out;
        } else {
            resp.sendRedirect(RedirectPath.MAIN_REDIRECT.getValue());
            return null;
        }
    }

    @PostMapping
    public void editAd(HttpServletRequest req, HttpServletResponse resp,
                      @RequestParam String id,
                      @RequestParam(required = false) String name,
                      @RequestParam(required = false) String descr,
                      @RequestParam(required = false) String pic,
                      @RequestParam(required = false) Integer price,
                      @RequestParam(required = false) String city,
                      @RequestParam(required = false) String email,
                      @RequestParam(required = false) String phone,
                      @RequestParam(required = false) String edit,
                      @RequestParam(required = false) String setFavor,
                      @RequestParam(required = false) String delFavor,
                      @RequestParam(required = false) String setTop,
                      @RequestParam(required = false) String delete) throws IOException {
        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        Ad ad = adService.getById(id);
        if (userFromSession != null && ad!= null && userFromSession.getId().equals(ad.getUserId())) {
            if ("true".equals(setFavor)) {
                adService.updateFavorite(id);
            }
            if ("true".equals(delFavor)) {
                adService.deleteFavorite(id);
            }
            if ("true".equals(setTop)) {
                adService.updateCurrentDate(id);
            }
            if ("true".equals(delete)) {
                adService.remove(ad);
            }
            if ("true".equals(edit)){
                ad.setName(name);
                ad.setDescr(descr);
                ad.setPic(pic);
                ad.setPrice(price);
                ad.setCity(city);
                ad.setPhone(phone);
                ad.setEmail(email);
                adService.update(ad);
            }
        }
        resp.sendRedirect(RedirectPath.MAIN_REDIRECT.getValue());
    }
}
