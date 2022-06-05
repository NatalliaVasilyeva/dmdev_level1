package org.dmdev.natalliavasilyeva.streams.model;

import java.util.Objects;

public class Mark {

    private final String subject;
    private final int value;

    public Mark(String name, int value) {
        this.subject = name;
        this.value = value;
    }

    public String getSubject() {
        return subject;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mark mark = (Mark) o;
        return getValue() == mark.value && Objects.equals(getSubject(), mark.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubject(), getValue());
    }

    @Override
    public String toString() {
        return "Mark{" +
                "name='" + getSubject() + '\'' +
                ", value=" + getValue() +
                '}';
    }
}