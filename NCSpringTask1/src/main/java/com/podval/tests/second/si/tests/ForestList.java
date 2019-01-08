package com.podval.tests.second.si.tests;

import java.util.List;

public class ForestList{

    private List<Tree> trees;

    public void sway(){
        for (Tree tree : trees){
            tree.sway();
        }
    }

    public List<Tree> getTrees() {
        System.out.println("using get for forest list");
        return trees;
    }

    public void setTrees(List<Tree> trees) {
        System.out.println("using set for forest list");
        this.trees = trees;
    }
}
