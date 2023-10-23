package com.example.myhomework2;

import org.springframework.web.bind.annotation.*;

/**
 * @PACKAGE_NAME: com.example.demo
 * @NAME: HelloController
 * @USER: jiang000
 * @DATE: 2023/9/27
 **/

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    // http:localhost:8080/index?name=123&password=456
    public String getNameAndPassword(String name, String password){
        System.out.println("name : " + name);
        System.out.println("password : " + password);
        return "myhello";
    }
    public String getName(@RequestParam(value = "name", required = false) String password){
        System.out.println("password : " + password);
        return "myhello";

    }

    @GetMapping("/**")
    public String index(){
        return "index page";
    }

}
