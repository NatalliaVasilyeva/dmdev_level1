package org.dmdev.natalliavasilyeva.inheritance.model;

public enum PlanetSize {
    S("Small"),
    A("Average"),
    G("Giant");

    private final String name;

    PlanetSize(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}