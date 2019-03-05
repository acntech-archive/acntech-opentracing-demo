package no.acntech.servicec;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("helloa")
    public ResponseEntity<String> helloa() {
        return ResponseEntity.ok("Poker Face");
    }

    @GetMapping("hellob")
    public ResponseEntity<String> hellob() {
        return ResponseEntity.ok("papapa Poker Face papapa");
    }
}
