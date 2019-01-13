package com.podval.main;

import com.podval.models.IModel;
import com.podval.services.IService;

import java.lang.reflect.Method;
import java.util.Scanner;

public abstract class ConsoleObjectService implements IConsoleObjectService {

    private String modelName;
    private Class modelClass;
    private IService service;

    ConsoleObjectService(){
    }

    ConsoleObjectService(Class modelClass, IService service){
        this.modelClass = modelClass;
        this.service = service;
        String[] strings = modelClass.getName().split("\\.");
        modelName = strings[strings.length - 1].toLowerCase();
    }

    @Override
    public int menu() {
        System.out.println("What do you want to do?");
        System.out.println("0. Exit");
        System.out.println("1. Add new " + modelName);
        System.out.println("2. Delete " + modelName + " by id");
        System.out.println("3. Update " + modelName + " by id");
        System.out.println("4. Print all " + modelName);
        System.out.println("5. Count of " + modelName);

        System.out.print("Input: ");
        int result = new Scanner(System.in).nextInt();
        System.out.println();

        return result;
    }

    @Override
    public void printAll() {
        System.out.println(service.findAll());
    }

    @Override
    public void addNew() {
        service.save(init());
    }

    @Override
    public void deleteById() {
        System.out.println("Input id: ");
        service.deleteById(new Scanner(System.in).nextInt());
    }

    @Override
    public void updateById() {
        System.out.println("Input id: ");
        IModel oldModel = service.find(new Scanner(System.in).nextInt());
        IModel newModel = init();

        try {
            Method setMethod = modelClass.getMethod("setId", int.class);
            Method getMethod = modelClass.getMethod("getId");
            setMethod.invoke(newModel, getMethod.invoke(oldModel));
        }catch (Exception e){
            e.printStackTrace();
        }

        service.update(newModel);
    }

    @Override
    public void count(){
        System.out.println("Current rows count is " + service.count());
    }

    @Override
    public Integer processAnswer(Integer answer) {
        switch (answer){
            case 0:
                return 0;
            case 1:
                addNew();
                return 1;
            case 2:
                deleteById();
                return 2;
            case 3:
                updateById();
                return 3;
            case 4:
                printAll();
                return 4;
            case 5:
                count();
                return 5;
            default:
                return -2;
        }
    }
}
