package assertions;

import models.Subscription;

import static org.junit.jupiter.api.Assertions.*;

public class SubscriptionAssertions {
    public static void assertSubscriptionEquals(
            Subscription actualSubscription,
            int expectedUserId,
            String expectedType,
            double expectedPrice,
            boolean expectedActive
    ){
        assertNotNull(actualSubscription);

        assertEquals(expectedUserId, actualSubscription.getUserId());
        assertEquals(expectedType, actualSubscription.getType());
        assertEquals(expectedPrice, actualSubscription.getPrice());
        assertEquals(expectedActive, actualSubscription.isActive());
    }
}
