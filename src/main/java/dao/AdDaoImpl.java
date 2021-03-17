package dao;

import data.Ad;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.UUID;

@Component
public class AdDaoImpl implements AdDao {
    @Override
    public void add(Ad ad) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        ad.setId(UUID.randomUUID().toString());
        s.save(ad);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public Ad getById(String id) {
        Session s = HibernateUtil.getSession();
        Ad out = (Ad) s.createQuery(String.format("FROM Ad WHERE id='%d", id)).uniqueResult();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> get() {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery("FROM Ad").list();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> getByRubric(Integer rubric) {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery(String.format("FROM Ad WHERE rubric=%d", rubric)).list();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> getByCity(String cityId) {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery("FROM Ad WHERE city='"+ cityId+"'").list();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> getByUserId(String userId) {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery(String.format("FROM Ad WHERE userId='%d'", userId)).list();
        s.close();
        return out;
    }

    @Override
    public void edit(Ad ad) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.update(ad);
        s.getTransaction().commit();
        s.close();
    }
}
