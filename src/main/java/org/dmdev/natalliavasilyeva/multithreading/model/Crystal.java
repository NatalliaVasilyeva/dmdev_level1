package org.dmdev.natalliavasilyeva.multithreading.model;

public class Crystal {
    private final Color color;

    public Crystal(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Crystal{" +
                "color=" + color +
                '}';
    }
}