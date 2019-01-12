package com.podval.services;

import com.podval.dao.IBaseDao;
import com.podval.models.IModel;

import java.util.List;

public class ServiceImpl implements IService {
    protected IBaseDao baseDao;

    ServiceImpl(IBaseDao baseDao){
        this.baseDao = baseDao;
    }

    @Override
    public IModel find(int id) {
        return baseDao.findById(id);
    }

    @Override
    public void save(IModel model) {
        baseDao.save(model);
    }

    @Override
    public void delete(IModel model) {
        baseDao.delete(model);
    }

    @Override
    public void deleteById(int id) {
        baseDao.delete(baseDao.findById(id));
    }

    @Override
    public void update(IModel model) {
        baseDao.update(model);
    }

    @Override
    public List findAll() {
        return baseDao.findAll();
    }

    @Override
    public List findAllId() {
        return baseDao.getDifferent("id", Integer.class);
    }

    @Override
    public Integer count() {
        return baseDao.count();
    }

    protected List getDifferent(String property, Class propertyClass){
        return baseDao.getDifferent(property, propertyClass);
    }

    protected List getModelsWithRestrictions(String condition){
        return baseDao.getModelsWithRestrictions(condition);
    }
}
