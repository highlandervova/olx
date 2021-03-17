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

    public Collection<Ad> getByAdCity(String cityId) {
        Collection<Ad> out = adDao.getByCity(cityId);
        return out;
    }

    public Collection<Ad> getByAd() {
        Collection<Ad> out = adDao.get();
        return out;
    }
}