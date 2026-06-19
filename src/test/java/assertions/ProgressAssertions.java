package assertions;

import models.Progress;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ProgressAssertions {
    public static void assertProgressMatchesExpected(
            Progress actualProgress,
            int expectedId,
            int expectedUserId,
            int expectedWorkoutsCompleted,
            int expectedCaloriesBurned,
            Date expectedLastUpdated){

        assertNotNull(actualProgress);
        assertEquals(expectedId, actualProgress.getId());
        assertEquals(expectedUserId, actualProgress.getUserId());
        assertEquals(expectedWorkoutsCompleted, actualProgress.getWorkoutsCompleted());
        assertEquals(expectedCaloriesBurned, actualProgress.getCaloriesBurned());
        assertEquals(expectedLastUpdated, actualProgress.getLastUpdated());
    }
}
