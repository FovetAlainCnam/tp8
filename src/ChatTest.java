import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ChatTest {
    @Test
    public void testCreateChatUser() {
        IChatRoom chatroom = new ChatRoom();

        User user1 = new ChatUser(chatroom,"1", "Alex");
        assertNotNull(user1);
    }

    @Test
    public void testAddChatUser() {
        IChatRoom chatroom = new ChatRoom();

        User user1 = new ChatUser(chatroom,"1", "Alex");

        chatroom.addUser(user1);

        assertEquals(1, ((ChatRoom) chatroom).getSize());
    }

    @Test
    public void testSendMessage() {
        IChatRoom chatroom = new ChatRoom();

        User user1 = new ChatUser(chatroom,"1", "Alex");
        User user2 = new ChatUser(chatroom,"2", "Brian");

        chatroom.addUser(user1);
        chatroom.addUser(user2);

        user1.send("Hello brian", "2");
        user2.send("Hey buddy", "1");

        assertEquals("Hello brian", user2.getMessage());
        assertEquals("Hey buddy", user1.getMessage());
    }
}
