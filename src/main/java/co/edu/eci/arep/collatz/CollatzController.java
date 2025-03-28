package co.edu.eci.arep.collatz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static co.edu.eci.arep.collatz.RoundRobbin.getConnection;

@RestController
public class CollatzController {
    private static final String operation = "collatzsequence";
    private static final String output = "";

    @GetMapping("/collatzsequence")
    public Collatz collatz(@RequestParam(value = "input") String input) throws IOException {

        return new Collatz(operation, input, getConnection(input).toString());
    }


}
