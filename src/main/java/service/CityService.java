package service;

import dao.CityDao;
import data.City;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class CityService {
    private final CityDao cityDao;
    private  UserService userService;

    public CityService(CityDao cityDao, UserService userService) {
        this.userService = userService;
        this.cityDao = cityDao;
    }


    public Collection<City> getCities() {
        Collection<City> out = cityDao.get();
        return out;
    }



        public City getById(String cityId) {
       City c = cityDao.getById(cityId);
        return c;
    }

    public Collection<City> getOtherCities(String id){
        Collection<City> out1 = cityDao.get();
        Collection<City> out2= new ArrayList();
        out2.add(getById(id));
        out1.removeAll(out2);
        return out1;
    }

}
