package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

public enum Model {

    SEDAN("SEDAN"),
    CARGO("CARGO"),
    MINIVAN("MINIVAN");

    String name;

    Model(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}