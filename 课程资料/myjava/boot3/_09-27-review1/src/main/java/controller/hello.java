package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PACKAGE_NAME: controller
 * @NAME: hello
 * @USER: jiang000
 * @DATE: 2023/9/27
 **/
@Controller
public class hello {
    @GetMapping("/hello")
    public String hello(){
        return "hello, world";
    }

}
