package co.edu.eci.arep.collatz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class ProxyServer {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(MathService.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8085"));
		app.run(args);
	}

}
