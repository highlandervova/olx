package dao;


import data.Rubric;

import java.util.Collection;

public interface RubricDao {
    Rubric getById(Integer id);
    Collection<Rubric> get();

}
