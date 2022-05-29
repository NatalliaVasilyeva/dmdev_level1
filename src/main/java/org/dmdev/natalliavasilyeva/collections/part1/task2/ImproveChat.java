package org.dmdev.natalliavasilyeva.collections.part1.task2;

import java.util.List;
import java.util.Objects;

public class ImproveChat {

    private final String name;
    private final List<User> users;

    public ImproveChat(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImproveChat chat = (ImproveChat) o;
        return Objects.equals(name, chat.name) && Objects.equals(users, chat.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, users);
    }

    @Override
    public String toString() {
        return "Chat{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}