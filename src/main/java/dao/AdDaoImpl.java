package dao;

import data.Ad;
import hibernate.HibernateUtil;
import org.hibernate.Query;
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
        Ad out = (Ad) s.createQuery("FROM Ad WHERE id='"+id+"'").uniqueResult();
        s.close();
        return out;
    }



    @Override
    public Collection<Ad> get() {
        Session s = HibernateUtil.getSession();
        //Collection<Ad> out = s.createQuery("SELECT  ad.id,ad.name,ad.descr,ad.pic,ad.price,ad.userId,ad.city,ad.phone,ad.email,ad.rubric, TO_CHAR(ad.date, 'DD/MM/YYYY'),ad.favor FROM Ad ad order by ad.date  desc").list();
        Collection<Ad> out = s.createQuery("FROM Ad order by date  desc").list();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> getFavorTop3() {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery("FROM  Ad where favor=1 order by random() limit 3").list();
        //Collection<Ad> out = s.createQuery("FROM (select * from Ad where Ad.favor=1 order by random() limit 3) as ADT order by date desc").list();
        s.close();
        return out;
    }

    @Override
    public Collection<Ad> getByFavor() {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery(String.format("FROM Ad WHERE favor=1")).list();
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
    public Collection<Ad> getByDescr(String decsr) {
        Session s = HibernateUtil.getSession();
        Collection<Ad> out = s.createQuery("FROM Ad WHERE lower(descr) LIKE lower('%"+ decsr+"%')").list();
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

    @Override
    public void remove(Ad ad) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        s.delete(ad);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public boolean updateAdDate(String id ) {
           Session s = HibernateUtil.getSession();
           s.beginTransaction();
           Query query = s.createQuery("UPDATE Ad set date=current_timestamp WHERE id=\'"+ id + "\'");
           query.executeUpdate();
           s.getTransaction().commit();
           s.close();
           return true;
    }

    @Override
    public boolean updateAdFavor(String id ) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Query query = s.createQuery("UPDATE Ad set favor=1 WHERE id=\'"+ id + "\'");
        query.executeUpdate();
        s.getTransaction().commit();
        s.close();
        return true;
    }

    @Override
    public boolean deleteAdFavor(String id ) {
        Session s = HibernateUtil.getSession();
        s.beginTransaction();
        Query query = s.createQuery("UPDATE Ad set favor=0 WHERE id=\'"+ id + "\'");
        query.executeUpdate();
        s.getTransaction().commit();
        s.close();
        return true;
    }
}
