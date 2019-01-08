package com.podval.tests.second.ci.tests;

import java.util.Map;

public class ForestMap {

    private Map<Tree, String> trees;

    public ForestMap(Map<Tree, String> trees){
        System.out.println("Forest map created");
        this.trees = trees;
    }

    public void sway(){
        for (Map.Entry<Tree, String> tree : trees.entrySet()){
            tree.getKey().sway();
        }
    }
}
