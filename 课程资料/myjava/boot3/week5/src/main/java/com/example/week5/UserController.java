package com.example.week5;

import com.example.week5.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PACKAGE_NAME: com.example.week5
 * @NAME: UserController
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @GetMapping("/users")
    public String query(){
        System.out.println(userMapper.find());
        return "query";
    }
}
