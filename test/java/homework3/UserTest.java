package homework3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    @Test
    void testUserAccess() {
        User user = new User("User", "Password", false);
        assertTrue(user.authenticate("User", "Password"));
    }

    @Test
    void testUserDenied() {
        User user = new User("User1", "Password1", false);
        assertFalse(user.authenticate("User", "Password"));
    }
}