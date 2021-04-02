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
    Collection<Ad> getByName(String name);
    Collection<Ad> getByFavor();
    boolean updateAdDate(String id );
    boolean updateAdFavor(String id);
    boolean deleteAdFavor(String id );
    void edit(Ad ad);
    void remove(Ad ad);
    void updatePicture(String id, byte[] fis);
}
