package controller;


import dao.AdDao;
import dao.UserDao;
import data.User;
import enums.RedirectPath;
import enums.RequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;
import service.ValidationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("reg")
public class RegController {

    private final UserDao userDao;
    private ValidationService validationService;
    private final UserService userService;


    @Autowired
    public RegController(
            final   UserService userService,
            final UserDao userDao,
//            @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
            ValidationService validationService

    ) {
        super();
        this.userDao = userDao;
        this.validationService = validationService;
        this.userService = userService;
    }



    /*
   private final CarrierService carrierService;
    private final CabinLevelService cabinLevelService;
    private final CompanyTypeService companyTypeService;

    private final List<DTOCompanyType> companyTypes;
    private final List<DTOCarrier> carrierLists;
    private final List<DTOCabinLevel> cabinLevels;

    @Autowired
    public TicketRuleController(
            final CarrierService carrierService,
            final CabinLevelService cabinLevelService,
            final CompanyTypeService companyTypeService
        ) {
        super();
        this.carrierService = carrierService;
        this.cabinLevelService = cabinLevelService;
        this.companyTypeService = companyTypeService;
        companyTypes = companyTypeService.loadAllCompanyTypes();
        carrierLists = carrierService.loadAllCarriers();
        cabinLevels = cabinLevelService.loadAllCabinLevel();
    }
   * */


//    public RegController(@Autowired UserDao userDao) {
//        this.userDao = userDao;
//    }

//    public RegController(UserDao userDao, @Autowired validationService validationService) {
//        this.userDao = userDao;
//        this.validationService = validationService;
//    }

//    @Autowired
//    public RegController() {
//        this(UserDao userDao, validationService Val, );
//    }
//
//    @Autowired
//    public RegController(
//             UserDao userDao,
//             validationService validationService,
//             UserService userService) {
//        this.userDao = userDao;
//        this.validationService = validationService;
//        this.userService = userService;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView regGet(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView out = new ModelAndView("reg");
        out.addObject("title", "reg page");
        String pathMain = RedirectPath.MAIN_PAGE.getValue();
        out.addObject("pathMain", pathMain);
        //  out.addObject("user", userDao.add());

        return out;
    }


    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView postGet(HttpServletRequest req, HttpServletResponse resp) {
        ModelAndView out2 = new ModelAndView("reg");
        out2.addObject("title", "reg page");

        String login = req.getParameter(RequestParameter.LOGIN.getValue());
        String pass1 = req.getParameter(RequestParameter.PASS1.getValue());
        String pass2 = req.getParameter(RequestParameter.PASS2.getValue());
        String city = req.getParameter(RequestParameter.CITY.getValue());
        String phone = req.getParameter(RequestParameter.PHONE.getValue());
        String email = req.getParameter(RequestParameter.EMAIL.getValue());

        if (validationService.validateRegistration(login, pass1, pass2)) {
               userService.addNewUser(login, pass1, city, phone, email);}
        String pathMain = RedirectPath.MAIN_PAGE.getValue();
        out2.addObject("pathMain", pathMain);
        return out2;
    }

}









