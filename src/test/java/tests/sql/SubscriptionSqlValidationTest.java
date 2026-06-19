package tests.sql;

import assertions.SubscriptionAssertions;
import database.SubscriptionDataRetriever;
import models.Subscription;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionSqlValidationTest {
    @Test
    public void shouldFetchSubscriptionByUserIdFromDatabase(){
        int userId = 1;

        Subscription subscription = SubscriptionDataRetriever.getSubscriptionByUserId(userId);

        SubscriptionAssertions.assertSubscriptionEquals(
                subscription,
                userId,
                "MONTHLY",
                9.99,
                true
        );
    }

    @Test
    void shouldReturnNullForNonExistentSubscription(){
        Subscription subscription = SubscriptionDataRetriever.getSubscriptionByUserId(99999);

        assertNull(subscription);
    }
}
