package debug;

import database.UserDataRetriever;
import models.User;

public class UserLookupTest {
    public static void main(String[] args) {
        User user = UserDataRetriever.getUserByEmail("jeffN@email.com");

        System.out.println(user.getName());
    }
}
