package com.podval.tests.second.si.tests;

import java.util.Set;

public class ForestSet {

    private Set<Tree> trees;

    public void sway(){
        for (Tree tree : trees){
            tree.sway();
        }
    }

    public Set<Tree> getTrees() {
        System.out.println("using get for forest set");
        return trees;
    }

    public void setTrees(Set<Tree> trees) {
        System.out.println("using set for forest set");
        this.trees = trees;
    }
}
