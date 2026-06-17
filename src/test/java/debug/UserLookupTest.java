package debug;

import database.UserDataRetriever;
import models.User;

public class UserLookupTest {
    public static void main(String[] args) {
        User user = UserDataRetriever.getUserById(1);

        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getEmail());
    }
}
