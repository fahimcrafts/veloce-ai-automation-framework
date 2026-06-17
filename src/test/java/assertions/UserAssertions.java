package assertions;

import models.User;
import static org.junit.jupiter.api.Assertions.*;


public class UserAssertions {
    public static void assertUserEquals(User actualUser, int expectedId, String expectedName, String expectedEmail){
        assertNotNull(actualUser);

        assertEquals(expectedId, actualUser.getId());
        assertEquals(expectedName, actualUser.getName());
        assertEquals(expectedEmail, actualUser.getEmail());
    }
}
