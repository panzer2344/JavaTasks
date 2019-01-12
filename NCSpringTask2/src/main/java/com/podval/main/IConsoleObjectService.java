package com.podval.main;

import com.podval.models.IModel;

public interface IConsoleObjectService {

    IModel init();
    int menu();
    void printAll();
    void addNew();
    void deleteById();
    void updateById();
    Integer processAnswer(Integer answer);
    void count();
}
