package org.dmdev.natalliavasilyeva.collections.practicetask2.second.car;

public enum Color {

    BLACK("BLACK"),
    WHITE("WHITE"),
    RED("RED");

    String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}