package controller;

import data.Ad;
import data.User;
import enums.RedirectPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;

import static enums.SessionAttribute.AUTHENTICATED;

@Controller
public class UploadAdController {
    private final AdService adService;
    private final CityService cityService;
    private final MessageService messageService;
    private final RubricService rubricService;
    private final FileService fileService;

    @Autowired
    public UploadAdController(AdService adService, CityService cityService,
                              MessageService messageService, RubricService rubricService,
                              FileService fileService) {
        this.adService = adService;
        this.cityService = cityService;
        this.messageService = messageService;
        this.rubricService = rubricService;
        this.fileService = fileService;
    }

    @RequestMapping(value = "/uploadAd", method = RequestMethod.GET)
    public String startUpload(HttpServletResponse resp, HttpServletRequest req, Model model,
                              @RequestParam(name = "id", required = true) String id) throws IOException {
        Ad ad = adService.getById(id);
        //model.addAttribute("ads", adService.getAll());
        model.addAttribute("ad", adService.getById(id));
        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());

        if (ad != null) {
            if (userFromSession != null && userFromSession.getId().equals(ad.getUserId())) {
                model.addAttribute("uploadAd");



            }
        }
        return "uploadAd";


    }




    // Handler Method for file upload
    @RequestMapping(value = "/uploadAd", method = RequestMethod.POST)
    public String uploadFile(
            HttpServletResponse resp, HttpServletRequest req,
            @RequestParam("file") MultipartFile file,
            @RequestParam String id,
            Model model) throws IOException {


        User userFromSession = (User) req.getSession(false).getAttribute(AUTHENTICATED.getValue());
        Ad ad = adService.getById(id);
        if (userFromSession != null && ad != null && userFromSession.getId().equals(ad.getUserId())) {


            if(!file.isEmpty()) {
                if (fileService.checkFileExtend(file.getOriginalFilename())) {


                    ad.setPicType(file.getContentType());
                    try {

                        byte[] fileBytes = file.getBytes();
                        ad.setPicture(fileBytes);
                        adService.update(ad);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    model.addAttribute("file", file);
                    model.addAttribute("idAd", id);


                    resp.sendRedirect(RedirectPath.MAIN_REDIRECT.getValue());
                    return "uploadAd";

                }
            }
        }
        return "uploadAd";



    }

        }