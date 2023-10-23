package week5jdk8.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * @PACKAGE_NAME: week5jdk8.demo
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
