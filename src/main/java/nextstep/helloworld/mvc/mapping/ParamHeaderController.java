package nextstep.helloworld.mvc.mapping;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/param-header")
public class ParamHeaderController {

    @GetMapping(value = "/message")
    public ResponseEntity<String> message() {
        return ResponseEntity.ok().body("message");
    }

    @GetMapping(value = "/message" , params = "name")
    public ResponseEntity<String> messageForParam(String name) {
        return ResponseEntity.ok().body(name);
    }

    @GetMapping(path = "/message" , headers = "HEADER")
    public ResponseEntity<String> messageForHeader(@RequestHeader("HEADER") String headerValue) {
        return ResponseEntity.ok().body(headerValue);
    }
}
