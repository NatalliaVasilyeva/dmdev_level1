package org.dmdev.natalliavasilyeva.inheritance.model;

public enum Color {
    WHITE("WHITE"),
    BLACK("BLACK"),
    YELLOW("YELLOW"),
    GREEN("GREEN"),
    BLUE("BLUE");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}