package org.dmdev.natalliavasilyeva.collections.part2.task1.model;

public enum Genre {
    ACTION("ACTION"),
    DRAMA("DRAMA"),
    COMEDY("COMEDY"),
    MELODRAMA("MELODRAMA");

    private final String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}