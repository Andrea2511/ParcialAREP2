package co.edu.eci.arep.collatz;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class RoundRobbin {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static final String GET_URL = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=fb&apikey=Q1QZFVJQ21K7C6XM";
    private static final List<String> domains = Arrays.asList("","");
    private static int currentLog = 0;
    private RoundRobbin(){}

    public static JsonObject getConnection(String input) throws IOException {

        URL obj = getUrlByRoundRobbin(input);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        StringBuilder response = new StringBuilder();
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return new JsonParser().parse(String.valueOf(response)).getAsJsonObject();
    }

    private static URL getUrlByRoundRobbin(String input) throws MalformedURLException {

        String domain = domains.get(currentLog);
        currentLog = (currentLog + 1) % domains.size();

        System.out.println(currentLog);
        return new URL("http://" + "localhost:35000" + "/collatzsequence" + "?value=" + input);

    }


}
