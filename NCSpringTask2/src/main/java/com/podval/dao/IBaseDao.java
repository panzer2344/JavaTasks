package com.podval.dao;

import com.podval.models.IModel;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public interface IBaseDao {

    IModel findById(int id);

    void save(IModel model);

    void update(IModel model);

    void delete(IModel model);

    List findAll();

    Integer count();

    List getDifferent(String property, Class propertyClass);

    List getModelsWithRestrictions(String condition);

    /*List getModelsWithRestrictionsAndInnerJoin(String condition, String join);*/

    List getModelsWithRestrictionAndInnerJoin(String joinTableNameA, String pseudonimA, String joinOnA,
                                           String joinTableNameB, String pseudonimB, String joinOnB,
                                           String condition
    );

}
