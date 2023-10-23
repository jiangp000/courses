package org.example.homework1.h1;

import java.util.HashMap;

/**
 * @PACKAGE_NAME: org.example.homework1.h1
 * @NAME: h3
 * @USER: 潘江 2301210367
 * @DATE: 2023/9/22
 **/


// 创建User类，有成员变量username 和 password，有默认的初始值
// 使用hashmap用来存储账户名 和 对应的对象
// 登录的时候，输入username 和 password，如果和hashmap中完全一致，登录成功
// 否则登录失败

class User{
    // 用户的默认用户名与密码
    private String username = "user";
    private String password = "userkey";
    // 为用户名和口令赋值
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    // 无参数
    public User() {
    }
    // 为用户赋值
    public User(String username) {
        this.username = username;
    }
    // 设置口令
    public void setPassword(String password) {
        this.password = password;
    }
    // 获取口令
    public String getPassword() {
        return password;
    }
    //返回所有信息
    public String getInfo() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
public class h3 {

    // 用来存储所有用户的用户名和对应的对象
    private static HashMap<String, User> userinfo = new HashMap<>();

    // 登录判断逻辑
    private  static boolean login(String username, String password){
        if(userinfo.containsKey(username) && password.equals(userinfo.get(username).getPassword())) return true;
        return false;
    }

    public static void main(String[] args) {
        // 分别使用3个构造方法（无参数、为用户赋值、为用户名和口令赋值）来创建用户
        User user1 = new User("A","B");
        userinfo.put("A",user1);
        User user2 = new User();
        userinfo.put("user",user2);
        User user3 = new User("C");
        userinfo.put("C",user3);
        // 用户登录
        boolean isSuccess1 = login("A","B");
        // 用户修改自己的密码
        user1.setPassword("888888");
        // 用旧密码登录不进去
        boolean isSuccess2 = login("A","B");
        // 用修改后的密码可以登录进去
        boolean isSuccess3 = login("A","888888");
        // 最后的结果是 true  false  true
        System.out.println(isSuccess1 +  " " + isSuccess2 +  " " + isSuccess1);


    }
}
