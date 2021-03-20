package dao;

import data.Ad;

import java.util.Collection;

public interface AdDao {
    void add(Ad ad);
    Ad getById(String id);
    Collection<Ad> get();
    Collection<Ad> getByRubric(Integer rubric);
    Collection<Ad> getByUserId(String userId);
    Collection<Ad> getByCity(String cityId);
    Collection<Ad> getByDescr(String decsr);
    void edit(Ad ad);
    void remove(Ad ad);
}
