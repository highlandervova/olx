package dao;


import data.City;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class CityDaoImpl implements CityDao {

    @Override
    public Collection<City> get() {
            Session s = HibernateUtil.getSession();
            Collection<City> out = s.createQuery("FROM City").list();
            s.close();
            return out;


    }

    @Override
    public City getById(String id) {
        Session s = HibernateUtil.getSession();
        City out =(City) s.createQuery(String.format("FROM City WHERE id=%d", id)).uniqueResult();
        s.close();
        return out;
    }

    @Override
    public Collection<City> getByIdofCollection(String id) {
        Session s = HibernateUtil.getSession();
        Collection<City> out = s.createQuery("FROM City WHERE id='"+id+"'").list();
        s.close();
        return out;
    }
}
