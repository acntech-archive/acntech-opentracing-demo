package no.acntech.servicea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("hello")
public class HelloResource {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping
    public ResponseEntity<String> hello() {
        String respB = restTemplate.getForObject("http://localhost:8081/hello", String.class);
        String respC = restTemplate.getForObject("http://localhost:8082/helloa", String.class);
        return ResponseEntity.ok(String.format("Can't see my, can't see my %s %s", respB, respC));
    }
}
