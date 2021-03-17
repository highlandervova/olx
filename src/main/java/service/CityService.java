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




    public Collection<City> getAllCityService() {
        Collection<City> out = cityDao.get();
        return out;
    }

        public City getByCityService(String idCity) {

       City c = cityDao.getByCity(idCity);
        return c;
    }

}
