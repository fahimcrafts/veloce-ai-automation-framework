package base;

import java.net.http.HttpClient;

public class BaseTest {

    protected final String BASE_URL = "http://localhost:3000";

    protected final HttpClient client = HttpClient.newHttpClient();
}
