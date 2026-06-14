package tests;

import base.BaseTest;
import org.junit.jupiter.api.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import models.Workout;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CoreValidationTests extends BaseTest {
    int testCounter = 0;

    @BeforeEach
    void setUp(){
        testCounter++;
        System.out.println("Starting test #" + testCounter);
    }

    @AfterEach
    void tearDown(){
        System.out.println("Finished test #" + testCounter);
    }

    @Test
    @DisplayName("Validate GET /workouts returns successful status code")
    void validateGetWorkoutsStatusCode() throws IOException, InterruptedException{
        String endpoint = BASE_URL + "/workouts";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());

        assertNotNull(response.body());
        assertFalse(response.body().isBlank());
    }

    @Test
    @DisplayName("Validate GET /workouts response structure using JSON parsing")
    void validateWorkoutsJsonStructure() throws Exception{
        String endpoint = BASE_URL + "/workouts";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());

        ObjectMapper mapper = new ObjectMapper();
        Workout[] workouts = mapper.readValue(response.body(), Workout[].class);

        assertNotNull(workouts);
        assertTrue(workouts.length>0);
        assertNotNull(workouts[0].name);
    }

    @Test
    void shouldValidateFirstWorkoutObject() throws Exception{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/workouts"))
                .GET()
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        Workout[] workouts = mapper.readValue(response.body(), Workout[].class);

        Workout first = workouts[0];

        assertTrue(workouts.length >= 2);

        for(Workout workout : workouts){
            assertTrue(workout.id>0);
            assertNotNull(workout.name);
            assertTrue(workout.duration>0);
            assertNotNull(workout.difficulty);
            assertNotNull(workout.calories);
            assertNotNull(workout.type);
        }
    }

    @Test
    void shouldValidateLogin() throws IOException, InterruptedException{
        String requestbody = """
                {
                    "email": "test@veloce.ai",
                    "password": "password123"
                }""";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/users/login"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestbody))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.statusCode());
        System.out.println(response.body());

        assertEquals(200, response.statusCode());
        assertTrue(response.body().contains("email"));
        assertTrue(response.body().contains("password"));
    }

    @Test
    public void usersEndpoint_shouldReturn200() throws Exception {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/workouts"))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals(200, response.statusCode());
        assertTrue(response.body().length() > 0);
    }
}
