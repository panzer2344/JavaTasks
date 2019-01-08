package com.podval.tests.second.si.tests;

import java.util.Map;

public class ForestMap {

    private Map<Tree, String> trees;

    public void sway(){
        for (Map.Entry<Tree, String> tree : trees.entrySet()){
            tree.getKey().sway();
        }
    }

    public Map<Tree, String> getTrees() {
        System.out.println("using get for forest map");
        return trees;
    }

    public void setTrees(Map<Tree, String> trees) {
        System.out.println("using set for forest map");
        this.trees = trees;
    }
}
