package com.podval.dao;

import com.podval.models.IModel;
import org.hibernate.Session;

import java.util.function.BiConsumer;

public interface IBasicTransaction {
    void basicTransaction(BiConsumer<Session, IModel> sessionFunction, IModel model);
}
