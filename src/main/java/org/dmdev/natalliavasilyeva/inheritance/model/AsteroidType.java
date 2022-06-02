package org.dmdev.natalliavasilyeva.inheritance.model;

public enum AsteroidType {
    C("Carbon"),
    S("Silicon"),
    M("Metal");

    private final String name;

    AsteroidType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}