package service;

import dao.AdDao;
import data.Ad;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Collection<Ad> getAdsByUsers(String userid) {
        Collection<Ad> out = adDao.getByUserId(userid);
        return out;
    }

    public Collection<Ad> getByDescr(String descr) {
        Collection<Ad> out = adDao.getByDescr(descr);
        return out;
    }

    public Collection<Ad> getByName(String name) {
        Collection<Ad> out = adDao.getByName(name);
        return out;
    }

    public Collection<Ad> getAdsByRubric(int rubricId) {
        Collection<Ad> out = adDao.getByRubric(rubricId);
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
        List<Ad> outFavorTop3 = new ArrayList<>();
        Collection<Ad> inFavor = adDao.getByFavor();
        if (inFavor.size() > 3) {
            for (Integer intg : getRandomNumber()) {
                int i = 0;
                for (Ad in : inFavor) {
                    if (i == intg) {
                        outFavorTop3.add(in);
                        break;
                    }
                    i++;
                }
            }
        } else {
            for (Ad in : inFavor) {
                outFavorTop3.add(in);
            }
        }
        Collections.sort(outFavorTop3, new SortByDate()); //sort for dateTop3
        return outFavorTop3;
    }

    public String getSdf(Date date) {
        String d = new SimpleDateFormat("dd-MM-yyyy").format(date);
        return d;
    }

    private ArrayList<Integer> getRandomNumber() {  // get item of random without repeat
        ArrayList<Integer> numbersGenerated = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Random randNumber = new Random();
            int iNumber = randNumber.nextInt(adDao.getByFavor().size());

            if (!numbersGenerated.contains(iNumber)) {
                numbersGenerated.add(iNumber);
            } else {
                i--;
            }
        }
        return numbersGenerated;
    }

    public Collection<Ad> getUserAds(String usId) {
        return adDao.getByUserId(usId);
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
        adDao.updateAdDate(adId);
    }

    public void updateFavorite(String adId) {
        adDao.updateAdFavor(adId);
    }

    public void deleteFavorite(String adId) {
        adDao.deleteAdFavor(adId);
    }
}
