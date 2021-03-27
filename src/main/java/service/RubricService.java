package service;

import dao.RubricDao;
import data.Rubric;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class RubricService {
    private final RubricDao rubricDao;


    public RubricService(RubricDao rubricDao   ) {  this.rubricDao = rubricDao;}


    public Collection<Rubric> getRubrics() {Collection<Rubric> out = rubricDao.get(); return out; }



        public Rubric getById(Integer rubricId) { Rubric r = rubricDao.getById(rubricId); return r;}

    public Collection<Rubric> getOtherRubrics(Integer idAdsRubric){
        Collection<Rubric> out1 = rubricDao.get();
        Collection<Rubric> out2= new ArrayList();
        out2.add(getById(idAdsRubric)); ///rubricId fromAds
        out1.removeAll(out2);
        return out1;
    }

}
