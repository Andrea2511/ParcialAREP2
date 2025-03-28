package co.edu.eci.arep.collatz;

import com.google.gson.JsonObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class MathService {
    public static void main(String... args) {
        SpringApplication app = new SpringApplication(MathService.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "35000"));
        app.run(args);

        System.out.println(Arrays.toString(args));
    }

    private static JsonObject outputCollat(int n){

        List<Integer> output = collatz(n);
        JsonObject response = createJsonResponse(n, output);
        return response;
    }

    private static JsonObject createJsonResponse(int n, List<Integer> output) {

        JsonObject response = new JsonObject();
        response.addProperty("input", 13);
        response.addProperty("output", output.toString());
        return response;
    }

    private static List<Integer> collatz(int n){

        List<Integer> output = new ArrayList<>();

        if(n != 1){
            if(n % 2 == 0){
                output.add(n/2);
                return collatz(n/2);
            }
            else{
                output.add((3*n) + 1);
                return collatz((3*n) + 1);
            }
        }
        return output;
    }


}
