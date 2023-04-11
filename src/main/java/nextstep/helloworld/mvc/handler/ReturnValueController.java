package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @RequestMapping("/message")
    @ResponseBody
    public String string() {
        return "message";
    }

    @RequestMapping("/thymeleaf")
    public String thymeleaf() {
        return "sample";
    }

    @RequestMapping("/users")
    @ResponseBody
    public User responseBodyForUser() {
        return new User("name", "email");
    }

    @RequestMapping("/users/{id}")
    @ResponseBody
    public ResponseEntity responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @RequestMapping("/members")
    @ResponseBody
    public ResponseEntity responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

}
