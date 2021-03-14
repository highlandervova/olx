package service;

import dao.AdDao;
import data.Ad;
import org.springframework.stereotype.Service;

@Service
public class AdService {
    private final AdDao adDao;

    public AdService(AdDao adDao) {
        this.adDao = adDao;
    }

    public Ad add(Ad ad){
        adDao.add(ad);
        return ad;
    }
}
