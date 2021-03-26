package dao;



import data.Rubric;
import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class RubricDaoImpl implements RubricDao {

    @Override
    public Collection<Rubric> get() {
            Session s = HibernateUtil.getSession();
            Collection<Rubric> out = s.createQuery("FROM Rubric").list();
            s.close();
            return out;


    }

    @Override
    public Rubric getById(Integer id) {
        Session s = HibernateUtil.getSession();

        Rubric out =(Rubric) s.createQuery(String.format("FROM Rubric WHERE id='%d'", id)).uniqueResult();
        s.close();
        return out;
    }


}
