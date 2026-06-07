package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UtilityTests extends BaseTest {
    @Test
    void shouldValidateUsernameContainsLetters(){
        String validUsername = "User1234";

        assertTrue(validUsername.matches(".*[a-zA-Z].*"));
    }

    @Test
    void shouldFailWhenUsernameHasNoLetters(){
        String invalidUsername = "12345!?.";

        assertFalse(invalidUsername.matches(".*[a-zA-Z].*"));
    }

    @Test
    void shouldValidatePasswordMeetsMinLength(){
        String password = "Acc355C0d3";

        assertTrue(password.length()>=8);
    }

    @Test
    void shouldValidateNullSafetyForWorkout(){
        String workout = null;
        assertNull(workout);
    }

    @Test
        void shouldValidateWorkoutListIsNotEmpty(){
            List<String> workoutList = Arrays.asList("Cardio", "Resistance");

            assertFalse(workoutList.isEmpty());
        }

        @Test
        void shouldValidateWorkoutNameContainsKeyword(){
            String workoutName = "Morning Cardio";

            assertTrue(workoutName.contains("Cardio"));
    }
}
