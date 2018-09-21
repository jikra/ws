
package hello;

import hello.wsdl.GetGreetingResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(HelloClient quoteClient) {
		return args -> {
			String name = "Jikra";

			GetGreetingResponse response = quoteClient.getGreeting(name);
			System.err.println(response.getGreeting());
		};
	}

}
