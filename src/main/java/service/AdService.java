package service;

import dao.AdDao;
import data.Ad;
import data.User;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class AdService {
    private final AdDao adDao;

    public AdService(AdDao adDao) {
        this.adDao = adDao;
    }

    public Ad add(Ad ad) {
        adDao.add(ad);
        return ad;
    }

    public Collection<Ad> getAdsByCity(String cityId) {
        Collection<Ad> out = adDao.getByCity(cityId);
        return out;
    }

    public Collection<Ad> getByDescr(String descr) {
        Collection<Ad> out = adDao.getByDescr(descr);
        return out;
    }
    public Collection<Ad> getByFavorite() {
        Collection<Ad> out = adDao.getByFavor();
        return out;
    }
    public Collection<Ad> getAll() {
        Collection<Ad> out = adDao.get();
        return out;
    }

    public Collection<Ad> getFavor3() {
        Collection<Ad> out = adDao.getFavorTop3();
        return out;
    }


    public Ad getById(String adId) {
        return adDao.getById(adId);
    }


    public void update(Ad adToEdit) {
        adDao.edit(adToEdit);
    }

    public void remove(Ad ad) {
        adDao.remove(ad);
    }

    public void updateCurrentDate(String adId) {
        boolean UpAdDate = adDao.updateAdDate(adId);
        }

    public void updateFavorite(String adId) {
        boolean UpAdDate = adDao.updateAdFavor(adId);
    }

    public void deleteFavorite(String adId) {
        boolean UpAdDate = adDao.deleteAdFavor(adId);
    }
}