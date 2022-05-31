package unit.org.dmdev.natalliavasilyeva.collections.part1.task1;

import org.dmdev.natalliavasilyeva.collections.part1.task1.SimpleChat;
import org.dmdev.natalliavasilyeva.collections.part1.task1.SimpleChatUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimpleChatUtilTest {

    @Test
    public void FullFlowTest() {
        SimpleChat chat1 = new SimpleChat("first", 550);
        SimpleChat chat2 = new SimpleChat("second", 950);
        SimpleChat chat3 = new SimpleChat("third", 1050);
        SimpleChat chat4 = new SimpleChat("fourth", 2000);
        SimpleChat chat5 = new SimpleChat("fifth", 2000);


        //given
        List<SimpleChat> chats = new ArrayList<>(List.of(chat1, chat2, chat3, chat4, chat5));

        List<SimpleChat> chatsForTestSortingByDefault = new ArrayList<>(List.of(chat1, chat2, chat5));

        List<SimpleChat> expectedListOfChatsAfterRemoving = new ArrayList<>(List.of(chat3, chat4, chat5));

        List<SimpleChat> expectedListOfChatsAfterSorting = new ArrayList<>(List.of(chat5, chat4, chat3));

        List<SimpleChat> chatsAfterSortingByDefault = new ArrayList<>(List.of(chat5, chat1, chat2));

        //when
        List<SimpleChat> listOfChatsAfterRemoving = SimpleChatUtils.deleteChats(chats);

        //then
        Assertions.assertEquals(expectedListOfChatsAfterRemoving, listOfChatsAfterRemoving);

        //when
        List<SimpleChat> listOfChatsAfterSorting = SimpleChatUtils.sortChatsByUsersNumberAndName(listOfChatsAfterRemoving);

        //then
        Assertions.assertEquals(expectedListOfChatsAfterSorting, listOfChatsAfterSorting);

        //when
        Collections.sort(chatsForTestSortingByDefault);

        //then
        Assertions.assertEquals(chatsAfterSortingByDefault, chatsForTestSortingByDefault);
    }
}