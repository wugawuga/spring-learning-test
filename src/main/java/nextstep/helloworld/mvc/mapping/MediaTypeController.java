package nextstep.helloworld.mvc.mapping;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media-type")
public class MediaTypeController {

    @PostMapping(value = "/users", consumes = "application/json")
    public ResponseEntity createUser(@RequestBody User user) {
        Long id = 1L;
        return ResponseEntity.created(URI.create("/users/" + id)).build();
    }

    @RequestMapping(value = "/users", produces = "application/json")
    public ResponseEntity<List<User>> showUser() {
        List<User> users = Arrays.asList(
                new User("이름", "email"),
                new User("이름", "email")
        );
        return ResponseEntity.ok().body(users);
    }

    @RequestMapping(value = "/users", produces = "text/html")
    public String userPage() {
        return "user page";
    }
}
