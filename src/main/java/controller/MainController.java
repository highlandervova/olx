package controller;

import dao.AdDao;
import data.City;
import enums.RedirectPath;
import enums.RequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.AdService;
import service.CityService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("main")
public class MainController {

    //private final AdDao adDao;
    private final CityService cityService;
    private final AdService adService;
    private String idCity;

    @Autowired
    public MainController(
            //final AdDao adDao,
                           final CityService cityService,
                           final AdService adService )
    {
        //this.adDao = adDao;
        this.cityService = cityService;
        this.adService   = adService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainGet
    ( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ModelAndView out = new ModelAndView("main");
        out.addObject("title", "OLX main page");
//        out.addObject("ads", adDao.get());
        out.addObject("adCity", cityService.getAllCityService());
        String adPage = RedirectPath.AD_PAGE.getValue();
        out.addObject("pathAddAd", adPage);
        String pathReg = RedirectPath.REG_PAGE.getValue();
        out.addObject("pathReg", pathReg);
        String pathAuth = RedirectPath.LOGIN_PAGE.getValue();
        out.addObject("pathAuth", pathAuth);
        if ( req.getParameter(RequestParameter.TYPE.getValue()) == null )
        {
            out.addObject("ads", adService.getByAd());
        } else {
            out.addObject("ads", adService.getByAdCity( req.getParameter(RequestParameter.TYPE.getValue())));
        };

             return out;
    }
}
