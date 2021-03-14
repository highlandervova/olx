package controller;

import dao.AdDao;
import enums.RedirectPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("main")
public class MainController {

    private final AdDao adDao;

    public MainController(@Autowired AdDao adDao) {
        this.adDao = adDao;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView mainGet() {
        ModelAndView out = new ModelAndView("main");
        out.addObject("title", "OLX main page");
        out.addObject("ads", adDao.get());
        String pathMain = RedirectPath.REG_PAGE.getValue();
        out.addObject("pathMain", pathMain);
        return out;
    }
}
