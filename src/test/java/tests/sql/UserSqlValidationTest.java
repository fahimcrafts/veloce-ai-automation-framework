package tests.sql;

import database.UserDataRetriever;
import models.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserSqlValidationTest {
    @Test
    public void shouldFetchUserByEmailFromDatabase(){
        String email = "jeffn@email.com";

        User dbUser = UserDataRetriever.getUserByEmail(email);

        assertNotNull(dbUser);

        assertEquals("Jeff Nippard", dbUser.getName());
        assertEquals(email, dbUser.getEmail());
        assertEquals(1, dbUser.getId());
    }
}
