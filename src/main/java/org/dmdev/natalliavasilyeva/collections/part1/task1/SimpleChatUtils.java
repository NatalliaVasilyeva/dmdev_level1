package org.dmdev.natalliavasilyeva.collections.part1.task1;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class SimpleChatUtils {

    private static final Integer USERS_NUMBER_LIMIT = 1000;

    private static final Comparator<SimpleChat> BY_NAME_NATURAL_ORDER = Comparator.comparing(SimpleChat::getName);
    private static final Comparator<SimpleChat> BY_USERS_NUMBER_DESCENDING_ODER = Comparator.comparing(SimpleChat::getNumberOfUsers).reversed();
    private static final Comparator<SimpleChat> BY_USERS_NUMBER_AND_NAME =
            (SimpleChat o1, SimpleChat o2) ->
                    BY_USERS_NUMBER_DESCENDING_ODER.thenComparing(BY_NAME_NATURAL_ORDER).compare(o1, o2);

    public static List<SimpleChat> deleteChats(List<SimpleChat> chats) {
        Iterator<SimpleChat> iterator = chats.iterator();
        while (iterator.hasNext()) {
            int numberOfUsers = iterator.next().getNumberOfUsers();
            if (numberOfUsers < USERS_NUMBER_LIMIT) {
                iterator.remove();
            }
        }
        return chats;
    }

    public static List<SimpleChat> sortChatsByUsersNumberAndName(List<SimpleChat> chats) {
        chats.sort(BY_USERS_NUMBER_AND_NAME);
        return chats;
    }
}