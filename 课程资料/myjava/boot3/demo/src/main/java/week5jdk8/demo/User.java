package week5jdk8.demo;

/**
 * @PACKAGE_NAME: week5jdk8.demo
 * @NAME: User
 * @USER: jiang000
 * @DATE: 2023/10/12
 **/
import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
}
