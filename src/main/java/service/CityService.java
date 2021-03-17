package service;

import dao.CityDao;
import data.City;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CityService {
    private final CityDao cityDao;

    public CityService(CityDao cityDao) {
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

}
