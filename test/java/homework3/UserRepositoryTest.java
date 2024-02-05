package homework3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserRepositoryTest {

    List<User> data;

    @BeforeEach
    void testInit() {
        data = new ArrayList<>();
        User user1 = new User("User1", "Password1", false);
        User user2 = new User("User2", "Password2", true);
        User user3 = new User("User3", "Password3", false);
        User user4 = new User("User4", "Password4", true);
        User user5 = new User("User5", "Password5", false);
        User user6 = new User("User6", "Password6", true);

        user1.isAuthenticate = true;
        user2.isAuthenticate = true;
        user3.isAuthenticate = true;
        user4.isAuthenticate = false;
        user5.isAuthenticate = false;
        user6.isAuthenticate = false;

        data.add(user1);
        data.add(user2);
        data.add(user3);
        data.add(user4);
        data.add(user5);
        data.add(user6);
    }


    @Test
    void testAddUserIsAuthenticated() {
        UserRepository repo = new UserRepository();

        for (User user : data) {
            repo.addUser(user);
        }

        assertEquals(data.subList(0, 3), repo.data);
    }

    @Test
    void testUnloginUsersIfNotAdmin() {
        UserRepository repo = new UserRepository();

        for (User user : data) {
            repo.addUser(user);
        }

        repo.unloginAllCommonUsers();

        for (User user : repo.data) {
            if (!user.isAdmin) {
                assertFalse(user.isAuthenticate);
            }
        }
    }
}
