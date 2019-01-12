package com.podval.services;

import com.podval.models.IModel;

import java.util.List;

public interface IService {

    IModel find(int id);
    void save(IModel model);
    void delete(IModel model);
    void deleteById(int id);
    void update(IModel model);
    List findAll();
    List findAllId();
    Integer count();
}
