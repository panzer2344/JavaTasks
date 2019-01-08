package com.podval.tests.second.ci.tests;

import java.util.List;

public class ForestList{

    private List<Tree> trees;

    public ForestList(List<Tree> trees){
        System.out.println("Forest list created");
        this.trees = trees;
    }

    public void sway(){
        for (Tree tree : trees){
            tree.sway();
        }
    }

}
