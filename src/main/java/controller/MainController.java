package controller;

import data.Ad;
import data.User;
import enums.RedirectPath;
import enums.RequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.AdService;
import service.CityService;
import service.RubricService;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;


import static enums.SessionAttribute.AUTHENTICATED;


@Controller
@RequestMapping("main")
public class MainController {


    private final CityService cityService;
    private final AdService adService;
    private final UserService userService;
    private final RubricService rubricService;



    @Autowired
    public MainController(
                           final CityService cityService,
                           final AdService adService,
                           final UserService userService,
                           final RubricService rubricService)
    {
        this.cityService = cityService;
        this.adService   = adService;
        this.userService = userService;
        this.rubricService= rubricService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainGet
    ( HttpServletRequest req, HttpServletResponse resp)

            throws ServletException, IOException {
        ModelAndView out = new ModelAndView("main");

        out.addObject("title", "OLX main page");
        out.addObject("adCity", cityService.getCities());
        out.addObject("rubrics", rubricService.getRubrics());
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
        if ( req.getParameter(RequestParameter.RUBRICSEARCH.getValue()) != null )
        {
            if (Integer.valueOf(req.getParameter(RequestParameter.RUBRICSEARCH.getValue())) == -1){
                out.addObject("ads", adService.getAll());

            } else {
            out.addObject("ads",
                    adService.getAdsByRubric(Integer.valueOf(req.getParameter(RequestParameter.RUBRICSEARCH.getValue()))));
                }
            out.addObject("notTop", "1");
        }

        if ( req.getParameter(RequestParameter.FAVORSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getByFavorite());
            out.addObject("notTop", "1");

        }

        if ( req.getParameter(RequestParameter.USERADSSEARCH.getValue()) != null )
        {
            out.addObject("notTop", "1");
        }

        if ( req.getParameter(RequestParameter.DESCRSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getByDescr( req.getParameter(RequestParameter.DESCRSEARCH.getValue())));
            out.addObject("notTop", "1");
        }

        if ( req.getParameter(RequestParameter.NAMESEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getByName( req.getParameter(RequestParameter.NAMESEARCH.getValue())));
            out.addObject("notTop", "1");
        }

        String editU = RedirectPath.EDIT_USER.getValue();
        out.addObject("editU", editU);
        if(   req.getParameter(RequestParameter.LOGOFF.getValue()) != null){
            req.getSession().invalidate();
           }
       // HttpSession session = req.getSession(false);
        if ((req.getSession().getAttribute(AUTHENTICATED.getValue())) != null) {
            User user = (User) req.getSession().getAttribute(AUTHENTICATED.getValue());
            String userIdd = user.getId();
            out.addObject("idUser", userIdd);
            out.addObject("userads", userService.getByUsersFromAds());

        }
        if ( req.getParameter(RequestParameter.USERADSSEARCH.getValue()) != null )
        {
            out.addObject("ads",
                    adService.getUserAds( req.getParameter(RequestParameter.USERADSSEARCH.getValue())));
            out.addObject("notTop", "1");
        }





        return out;

    }
}
