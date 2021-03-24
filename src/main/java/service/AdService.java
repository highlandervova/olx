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

    public Collection<Ad> getAdsByUsers( String userid){
       Collection<Ad> out = adDao.getByUserId(userid );
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
        Collection<Ad> top = getFavor3();
        out.removeAll(top);
        return out;
    }



    public Collection<Ad> getFavor3() {
        Collection<Ad> outFavorTop3 = new ArrayList<>();
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
   //     Collections.sort(outFavorTop3, new SortByDate()); //sort for dateTop3


        //Handle sort. How do better?
//        Collection<Ad> sortFavor = new ArrayList<>();
//        Collection<Ad> sortFavor1 = new ArrayList<>();
//        Collection<Ad> sortFavor2 = new ArrayList<>();
//        Collection<Ad> sortFavor3 = new ArrayList<>();
//        int a =4;
//        int b,c;
//
//        int i=0;
//        for (Ad in: outFavorTop3) {
//            if (i == 0) {
//                sortFavor1.add(in);
//            }
//            if (i == 1) {
//                sortFavor2.add(in);
//            }
//            i++;
//            if(a<3) break;
//            for (Ad in1 : sortFavor1) { if (a<3 ) break;
//                for (Ad in2 : sortFavor2) {
//                    if (a<3) break;
//                       if (in.getDate().after(in1.getDate()) ) {a=1;}else {a=0;}
//                       if(in.getDate().after(in2.getDate()) ) {b=1;}else {b=0;}
//                       if (in1.getDate().after(in2.getDate()) ) {c=1;}else {c=0;}
//
//
//                       if(a==1||b==1||c==1){
//                        sortFavor3.add(in);
//                        sortFavor3.add(in1);
//                        sortFavor3.add(in2);
//                                        break;    }
//                    if(a==1||b==1||c==0){
//                        sortFavor3.add(in);
//                        sortFavor3.add(in2);
//                        sortFavor3.add(in1);
//                   break; }
//                    if(a==1||b==0||c==0){
//                        sortFavor3.add(in2);
//                        sortFavor3.add(in);
//                        sortFavor3.add(in1);
//                    break;}
//                    if(a==0||b==0||c==0){
//                        sortFavor3.add(in2);
//                        sortFavor3.add(in1);
//                        sortFavor3.add(in);
//                    break;}
//                    if(a==0||b==0||c==1){
//                        sortFavor3.add(in1);
//                        sortFavor3.add(in2);
//                        sortFavor3.add(in);
//                    }
//
//                    if(a==0||b==1||c==0){
//                        sortFavor3.add(in1);//abc
//                        sortFavor3.add(in2);
//                        sortFavor3.add(in);
//                    break;}
//                    if(a==0||b==1||c==1){
//                        sortFavor3.add(in1);//abc
//                        sortFavor3.add(in);
//                        sortFavor3.add(in2);
//                break;    }
//
//                }
//            }
//        }
//


        // return sortFavor3;
        return outFavorTop3;
    }






        // outFavorTop3.stream().sorted(Comparator.comparing(Ad::getDate)); // try 1 for sort


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
