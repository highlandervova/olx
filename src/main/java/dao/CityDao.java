package dao;


import data.City;

import java.util.Collection;

public interface CityDao {
    City getById(String id);
    Collection<City> get();

}
