package com.podval.tests.second.ci.tests;

import java.util.Set;

public class ForestSet {

    private Set<Tree> trees;

    public ForestSet(Set<Tree> trees){
        System.out.println("Forest set created");
        this.trees = trees;
    }

    public void sway(){
        for (Tree tree : trees){
            tree.sway();
        }
    }
}
