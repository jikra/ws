package hello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Application {

    public static void main(String args[]) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {

        return restTemplateBuilder.errorHandler(new ResponseErrorHandler()).build();
    }


    //@Bean
    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {

        return args -> {
            Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting1", Greeting.class);
            System.out.println(greeting);
        };
    }

    @Bean
    public CommandLineRunner commandLineRunner2(RestTemplate restTemplate) {

        return args -> {

                ResponseEntity responseEntity = restTemplate.postForEntity("http://localhost:8080/greeting",
                        new Greeting("j", 31),
                        String.class);
            System.out.println(responseEntity.getBody());
        };
    }
}
