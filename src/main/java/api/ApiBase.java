package api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiBase {

    public static int checkGetStatusCode(String url) throws IOException {
        URL u = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) u.openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        return connection.getResponseCode();
    }
}
