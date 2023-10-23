package week5jdk8.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

/**
 * @PACKAGE_NAME: week5jdk8.demo
 * @NAME: UserController
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUserByName(@RequestParam String name) {
        return userService.findUserByName(name);
    }
}

