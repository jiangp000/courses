package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @PACKAGE_NAME: com.example.demo
 * @NAME: UserService
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> findUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
