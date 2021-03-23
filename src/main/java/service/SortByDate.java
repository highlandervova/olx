package service;

import data.Ad;

import java.util.Comparator;

class SortByDate implements Comparator<Ad> { //comparator for FavorTop3

    public int compare(Ad o1, Ad o2) {
        return o1.getDate().compareTo(o2.getDate());
    }
}



