package tests.sql;

import assertions.ProgressAssertions;
import database.ProgressDataRetriever;
import models.Progress;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProgressSqlValidationTest {
    @Test
    public void shouldFetchProgressByIdFromDatabase(){
        int id = 1;

        Progress progress = ProgressDataRetriever.getProgressById(id);

        ProgressAssertions.assertProgressMatchesExpected(       progress,
                1,
                1,
                5,
                1200,
                Date.valueOf("2026-06-14")
                );
    }

    @Test
    void shouldReturnNullForNonExistentProgress(){
        Progress progress = ProgressDataRetriever.getProgressById(99999);

        assertNull(progress);
    }
}
