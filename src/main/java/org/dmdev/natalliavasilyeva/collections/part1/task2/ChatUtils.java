package org.dmdev.natalliavasilyeva.collections.part1.task2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ChatUtils {

    private static final Integer MINIMUM_USER_AGE = 18;

    public static List<User> getUsersOlderEighteenFromAllChats(List<Chat> chats) {
        List<User> users = new ArrayList<>();
        for (Chat chat : chats) {
            for (User user : chat.getUsers()) {
                if (user.getAge() >= MINIMUM_USER_AGE) {
                    users.add(user);
                }
            }
        }
        return users;
    }

    public static double calculateAverageUsersAge(List<User> users) {
        double sumOfUserAges = 0;
        int numberOfUsers = users.size();
        for (User user : users) {
            sumOfUserAges += user.getAge();
        }
        return sumOfUserAges / numberOfUsers;
    }

    public static double calculateAverageUsersAgeUsingIterator(List<User> users) {
        double sumOfUserAges = 0.0;
        int numberOfUsers = users.size();
        Iterator<User> iterator = users.listIterator();
        while (iterator.hasNext()) {
            sumOfUserAges += iterator.next().getAge();
        }
        return sumOfUserAges / numberOfUsers;
    }
}