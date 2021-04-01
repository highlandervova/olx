package controller;

import data.Ad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;

@Controller
@RequestMapping("olx_war/adImage")
public class AdImageController {

    private final AdService adService;
    @Autowired
    public AdImageController(AdService adService) { this.adService = adService;}

    @RequestMapping(value = "/imageDisplay", method = RequestMethod.GET)
    public void showImage(HttpServletResponse resp, HttpServletRequest req,
                          @RequestParam(name = "adId", required = true) String adId) throws IOException {

        Ad ad = adService.getById(adId);
        resp.setContentType("image/jepg, image/png, image/gif");
        byte[] imgBytes = ad.getClobfield();
        resp.getOutputStream().write(imgBytes);

        resp.getOutputStream().flush(); //close();

        //String url = "data:image/png;base64,"+ Base64.getEncoder().encodeToString(imgBytes);
        //req.getSession().setAttribute("url",url);

    }
}
