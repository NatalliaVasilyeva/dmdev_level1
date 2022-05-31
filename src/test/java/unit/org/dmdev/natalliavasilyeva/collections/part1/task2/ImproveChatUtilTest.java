package unit.org.dmdev.natalliavasilyeva.collections.part1.task2;

import org.dmdev.natalliavasilyeva.collections.part1.task2.Chat;
import org.dmdev.natalliavasilyeva.collections.part1.task2.ChatUtils;
import org.dmdev.natalliavasilyeva.collections.part1.task2.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ImproveChatUtilTest {

    @Test
    public void FullFlowTest() {
        //given
        User user1 =  new User(1, "DAN", 19);
        User user2 =  new User(2, "JANE", 15);
        User user3 =  new User(3, "IVAN", 30);
        User user4 =  new User(4, "KATE", 10);
        User user5 =  new User(5, "PIOTR", 25);
        User user6 =  new User(6, "ANDREW", 35);
        User user7 =  new User(7, "DIMA", 15);
        User user8 =  new User(8, "LEO", 80);
        User user9 =  new User(9, "TOTTI", 39);

        List<Chat> chats = new ArrayList<>(List.of(
                new Chat("first", List.of(user1, user2, user3)),
                new Chat("second", List.of(user4, user5, user6)),
                new Chat("third", List.of(user7, user8, user9))
        ));

        List<User> expectedListOfUsers = List.of(user1, user3, user5, user6, user8, user9);
        double expectedAverageAge = 38;

        //when
        List<User> actualListOfUsers = ChatUtils.getUsersOlderEighteenFromAllChats(chats);
        double actualAverageAge = ChatUtils.calculateAverageUsersAge(actualListOfUsers);
        double actualAverageAgeCountByUsingIterator = ChatUtils.calculateAverageUsersAgeUsingIterator(actualListOfUsers);

        //then
        Assertions.assertEquals(expectedListOfUsers, actualListOfUsers);
        Assertions.assertEquals(expectedAverageAge, actualAverageAge);
        Assertions.assertEquals(expectedAverageAge, actualAverageAgeCountByUsingIterator);

    }
}