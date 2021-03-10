package dao;

import data.Ad;

import java.util.Collection;

public interface AdDao {
    void add(Ad ad);
    Ad getById(String id);
    Collection<Ad> get();
    Collection<Ad> getByRubric(Integer rubric);
    Collection<Ad> getByUserId(String userId);
    void edit(Ad ad);
}
