package tests.sql;

import database.UserDataRetriever;
import models.User;
import org.junit.jupiter.api.Test;
import assertions.UserAssertions;

import static org.junit.jupiter.api.Assertions.*;

public class UserSqlValidationTest {
    @Test
    public void shouldFetchUserByEmailFromDatabase(){
        String email = "jeffn@email.com";

        User dbUser = UserDataRetriever.getUserByEmail(email);

        UserAssertions.assertUserEquals(dbUser, 1, "Jeff Nippard", email);
    }

    @Test
    public void shouldReturnNullWhenUserDoesNotExist(){
        String email = "doesnotexist@email.com";
        User dbUser = UserDataRetriever.getUserByEmail(email);

        assertNull(dbUser);
    }
}
