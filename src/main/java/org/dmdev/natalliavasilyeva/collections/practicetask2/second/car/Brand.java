package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

public enum Brand {
    BMW("BMW"),
    MERCEDES("MERCEDES"),
    VOLVO("VOLVO");

    String name;

    Brand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}