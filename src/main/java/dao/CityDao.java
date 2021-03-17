package dao;


import data.City;

import java.util.Collection;

public interface CityDao {
    City getByCity(String id);
    Collection<City> get();

}
