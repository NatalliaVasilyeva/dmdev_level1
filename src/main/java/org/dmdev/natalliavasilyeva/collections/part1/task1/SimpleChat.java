package org.dmdev.natalliavasilyeva.collections.part1.task1;

import java.util.Objects;

public class SimpleChat implements Comparable<SimpleChat> {

    private final String name;
    private final int numberOfUsers;

    public SimpleChat(String name, int numberOfUsers) {
        this.name = name;
        this.numberOfUsers = numberOfUsers;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfUsers() {
        return numberOfUsers;
    }

    @Override
    public int compareTo(SimpleChat chat) {

        return name.compareTo(chat.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleChat chat = (SimpleChat) o;
        return numberOfUsers == chat.numberOfUsers && Objects.equals(name, chat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, numberOfUsers);
    }

    @Override
    public String toString() {
        return "SimpleChat{" +
                "name='" + name + '\'' +
                ", numberOfUsers=" + numberOfUsers +
                '}';
    }
}