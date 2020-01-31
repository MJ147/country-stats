package com.mja.models;

public class Country {

    private String name;
    private int ladder;
    private int freedom;
    private int corruption;

    public Country(String name, int ladder, int freedom, int corruption) {
        this.name = name;
        this.ladder = ladder;
        this.freedom = freedom;
        this.corruption = corruption;
    }

    public String getName() {
        return name;
    }

    public int getLadder() {
        return ladder;
    }

    public int getFreedom() {
        return freedom;
    }

    public int getCorruption() {
        return corruption;
    }
}
