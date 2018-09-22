package hello;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class HelloController {

    @RequestMapping(path = "/greeting", method = RequestMethod.GET)
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "hello " + name;
    }



    @RequestMapping(path = "/greeting1", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting greeting1() {

        Greeting greeting = new Greeting();
        greeting.setAge(22);
        greeting.setName("jikra");
        return greeting;
    }

    @RequestMapping(path = "greeting", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addGreeting(@RequestBody @Valid Greeting greeting) {

        System.out.println(greeting);
        return ResponseEntity.ok(greeting.getName());
    }


}
