package no.acntech.serviceb;

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
        String resp = restTemplate.getForObject("http://localhost:8082/hellob", String.class);
        return ResponseEntity.ok(String.format("Poker Face %s", resp));
    }
}
