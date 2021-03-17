package service;

import dao.AdDao;
import data.Ad;
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

    public Collection<Ad> getAll() {
        Collection<Ad> out = adDao.get();
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
}