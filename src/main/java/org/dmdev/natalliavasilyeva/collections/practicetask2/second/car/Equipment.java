package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

public enum Equipment {

    GRASSCUTTER("GRASSCUTTER"),
    SPRINKLER("SPRINKLER"),
    TRAILER("TRAILER");

    String name;

    Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}