package controller;

import data.Ad;
import data.Message;
import data.User;
import enums.RedirectPath;
import enums.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
@RequestMapping("/editAd")
public class EditAdController {
    private final AdService adService;
    private final CityService cityService;
    private final MessageService messageService;
    private final RubricService rubricService;
    private final FileService fileService;

    @Autowired
    public EditAdController(AdService adService, CityService cityService,
                            MessageService messageService, RubricService rubricService,
                            FileService fileService) {
        this.adService = adService;
        this.cityService = cityService;
        this.messageService = messageService;
        this.rubricService = rubricService;
        this.fileService = fileService;
    }

    @GetMapping
    public ModelAndView getView(HttpServletResponse resp, HttpServletRequest req,
                                @RequestParam(name = "adId", required = true) String adId) throws IOException {
        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        Ad ad = adService.getById(adId);
        if (ad != null) {
            ModelAndView out = new ModelAndView("editAd");
            out.addObject("pathUpload", RedirectPath.UPLOAD_PAGE.getValue());
            if (userFromSession != null && userFromSession.getId().equals(ad.getUserId())) {
                out.addObject("edit", true);
                out.addObject("FavorYes", ad.getFavor());
                out.addObject("cityUser", userFromSession.getCity());
                out.addObject("rubricAd", ad.getRubric());
                out.addObject("rubrics", rubricService.getRubrics());
                out.addObject("otherRubrics", rubricService.getOtherRubrics(ad.getRubric()));
                out.addObject("otherCities", cityService.getOtherCities(userFromSession.getCity()));
                out.addObject("messages", messageService.getByAdId(adId));
            }
            if (userFromSession != null && !userFromSession.getId().equals(ad.getUserId())) {
                out.addObject("messages", messageService.getByAdIdAndUserId(adId, userFromSession.getId()));
            }
            out.addObject("pathMain", RedirectPath.MAIN_PAGE.getValue());
            out.addObject("pathEdit", RedirectPath.EDIT_AD.getValue());
            out.addObject("ad", adService.getById(adId));
            out.addObject("title", Title.EDIT_AD);
            out.addObject("adCity", cityService.getCities());
            out.addObject("user", userFromSession);
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
                       @RequestParam(required = false) Integer rubric,
                       @RequestParam(required = false) String city,
                       @RequestParam(required = false) String email,
                       @RequestParam(required = false) String phone,
                       @RequestParam(required = false) String edit,
                       @RequestParam(required = false) String setFavor,
                       @RequestParam(required = false) String delFavor,
                       @RequestParam(required = false) String setTop,
                       @RequestParam(required = false) String delete,
                       @RequestParam(required = false) String message) throws IOException {

        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        Ad ad = adService.getById(id);


        if (userFromSession != null && ad != null && userFromSession.getId().equals(ad.getUserId())) {



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
            if ("true".equals(edit)) {
                ad.setName(name);
                ad.setDescr(descr);
               // ad.setPictype(pic);
                ad.setPrice(price);
                ad.setRubric(rubric);
                ad.setCity(city);
                ad.setPhone(phone);
                ad.setEmail(email);
                adService.update(ad);
            }
        }
        if (userFromSession != null && ad != null && userFromSession.getId().equals(ad.getUserId())) {
            if (message != null && message.length() > 0) {
                Collection<Message> messages = messageService.getByAdId(ad.getId());
                if (messages != null && !messages.isEmpty()) {
                    Message found = null;
                    for (Message m : messages) {
                        if (found == null) {
                            if (m.getToUserId().equals(userFromSession.getId())) {
                                found = m;
                            } else {
                                continue;
                            }
                        } else {
                            if (m.getToUserId().equals(userFromSession.getId()) && found.getTs().getTime() < m.getTs().getTime()) {
                                found = m;
                            } else {
                                continue;
                            }
                        }
                    }
                    if (found != null) {
                        messageService.addMessage(message, userFromSession.getId(), found.getFromUserId(), ad.getId());
                    }
                }
            }
        }
        if (userFromSession != null && ad != null && !userFromSession.getId().equals(ad.getUserId())) {
            if (message != null && message.length() > 0) {
                messageService.addMessage(message, userFromSession.getId(), ad.getUserId(), ad.getId());
            }
        }
        resp.sendRedirect(RedirectPath.MAIN_REDIRECT.getValue());
    }
}

