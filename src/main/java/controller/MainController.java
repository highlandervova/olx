package controller;

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
import java.util.Date;


@Controller
@RequestMapping("main")
public class MainController {


    private final CityService cityService;
    private final AdService adService;
    private Date date;


    @Autowired
    public MainController(
                           final CityService cityService,
                           final AdService adService )
    {
        this.cityService = cityService;
        this.adService   = adService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainGet
    ( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ModelAndView out = new ModelAndView("main");
        out.addObject("title", "OLX main page");
        out.addObject("adCity", cityService.getCities());
        String adPage = RedirectPath.ADD_AD_PAGE.getValue();
        out.addObject("pathAddAd", adPage);
        String pathMain = RedirectPath.MAIN_PAGE.getValue();
        out.addObject("pathMain", pathMain);
        String pathReg = RedirectPath.REG_PAGE.getValue();
        out.addObject("pathReg", pathReg);
        String pathAuth = RedirectPath.LOGIN_PAGE.getValue();
        out.addObject("pathAuth", pathAuth);
        out.addObject("pathEdit", RedirectPath.EDIT_AD.getValue());
        if ( req.getParameter(RequestParameter.TYPE.getValue()) == null )
        {
            out.addObject("ads", adService.getAll());
            out.addObject("topAds",adService.getFavor3());
            out.addObject("notTop", "0");
        } else {
            out.addObject("ads",
                    adService.getAdsByCity( req.getParameter(RequestParameter.TYPE.getValue())));
            out.addObject("notTop", "1");
        };
        if ( req.getParameter(RequestParameter.CITYSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getAdsByCity( req.getParameter(RequestParameter.CITYSEARCH.getValue()))
            );
            out.addObject("notTop", "1");
        }

        if ( req.getParameter(RequestParameter.FAVORSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getByFavorite());
            out.addObject("notTop", "1");

        }

        if ( req.getParameter(RequestParameter.DESCRSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getByDescr( req.getParameter(RequestParameter.DESCRSEARCH.getValue())));
            out.addObject("notTop", "1");
        }

        String editU = RedirectPath.EDIT_USER.getValue();
        out.addObject("editU", editU);
        if(   req.getParameter(RequestParameter.LOGOFF.getValue()) != null){
            req.getSession().invalidate();
           }
        return out;

    }
}
