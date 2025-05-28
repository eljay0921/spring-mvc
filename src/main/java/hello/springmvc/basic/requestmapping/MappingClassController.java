package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping()
    public String users() {
        return "get all users";
    }

    @PostMapping()
    public String addUser() {
        return "add one user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId) {
        return "find one user : " + userId;
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId) {
        return "update one user : " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {
        return "delete one user : " + userId;
    }
}
