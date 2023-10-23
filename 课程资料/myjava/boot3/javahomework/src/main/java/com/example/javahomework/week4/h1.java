package com.example.javahomework.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PACKAGE_NAME: com.example.javahomework.week4
 * @NAME: 潘江
 * @USER: 2301210367
 * @DATE: 2023/10/6
 **/


// User类中有唯一的电话号码（用户ID），和对应的多个角色
// Role类中有唯一的角色ID，和对应的多个权限
// Authority中有唯一的权限ID
// Management作为管理类，存储了所有的User,Role,Authority,存储了他们之间的对应关系
// 并且实现了添加各种对应关系的实现，例如为用户分配新的角色，为角色分配新的权限
// 最后显式的实现了六个要求，根据用户得到对应的角色以及权限，根据权限得到有该权限的用户，以及角色，根据角色得到有该角色的用户，以及所具有的所有权限
class User {
    public User(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String phoneNumber;
    private String name = "123";
    private String password = "234";
    private short locked = 0;
    private List<Role> roles = new ArrayList<>();

    public void addRole(Role role) {
        roles.add(role);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User(String phoneNumber, String name, String password, short locked) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.locked = locked;
    }

    // 用户的初始化
    public User(String phoneNumber, String name, String password, short locked, List<Role> roles) {
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.password = password;
        this.locked = locked;
        this.roles = roles;
    }

    // 获取该用户的所有角色
    public List<Role> getRoles() {
        return roles;
    }
}

class Role {
    public Role(long roleId) {
        this.roleId = roleId;
    }

    private long roleId;
    private String name = "管理员";
    private String info = "我是管理员";
    private List<Authority> authorities = new ArrayList<>();

    public long getRoleId() {
        return roleId;
    }

    public void addAuthority(Authority authority) {
        authorities.add(authority);
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public Role(long roleId, String name, String info, List<Authority> authorities) {
        this.roleId = roleId;
        this.name = name;
        this.info = info;
        this.authorities = authorities;
    }

    public Role(long roleId, String name, String info) {
        this.roleId = roleId;
        this.name = name;
        this.info = info;
    }
}

class Authority {
    Long authId;
    String authName;
    String info;

    public Authority(String authName, String info) {
        this.authName = authName;
        this.info = info;
    }

    public Authority(Long authId, String authName, String info) {
        this.authId = authId;
        this.authName = authName;
        this.info = info;
    }

    public Authority(Long authId) {
        this.authId = authId;
    }

}

class Management {
    private Map<String, User> users = new HashMap<>(); // 存放所有的用户，一个电话号码对应唯一的用户
    private Map<Long, Role> roles = new HashMap<>(); //  存放所有的角色，每一个角色ID对应唯一的用户
    private Map<Long, Authority> authorities = new HashMap<>(); //  存放所有的角色，每一个角色ID对应唯一的用户
    private Map<String, List<Role>> rolesFromUser = new HashMap<>();                 //  存放一个用户的所有角色
    private Map<String, List<Authority>> authoritiesFromUser = new HashMap<>();       //   存放一个用户对应的所有权限
    private Map<Long, List<User>> usersFromRole = new HashMap<>();                 //  存放一个角色的所有用户
    private Map<Long, List<Authority>> authoritiesFromRole = new HashMap<>();       //   存放一个角色的所有权限
    private Map<Long, List<User>> usersFromAuthority = new HashMap<>();                 //  存放一个权限的所有用户
    private Map<Long, List<Role>> rolesFromAuthority = new HashMap<>();       //   存放一个权限的所有角色

    public Management(Map<String, User> users, Map<Long, Role> roles, Map<Long, Authority> authorities, Map<String, List<Role>> rolesFromUser, Map<String, List<Authority>> authoritiesFromUser, Map<Long, List<User>> usersFromRole, Map<Long, List<Authority>> authoritiesFromRole, Map<Long, List<User>> usersFromAuthority, Map<Long, List<Role>> rolesFromAuthority) {
        this.users = users;
        this.roles = roles;
        this.authorities = authorities;
        this.rolesFromUser = rolesFromUser;
        this.authoritiesFromUser = authoritiesFromUser;
        this.usersFromRole = usersFromRole;
        this.authoritiesFromRole = authoritiesFromRole;
        this.usersFromAuthority = usersFromAuthority;
        this.rolesFromAuthority = rolesFromAuthority;
    }

    public Management() {
    }

    // 添加用户
    public void addUser(User user) {
        users.put(user.getPhoneNumber(), user);
    }

    // 通过用户ID 得到用户
    public User getUser(String userId) {
        return users.get(userId);
    }

    // 添加角色
    public void addRole(Role role) {
        roles.put(role.getRoleId(), role);
    }

    // 通过角色ID 得到角色对象
    public Role getRole(Long roleId) {
        return roles.get(roleId);
    }

    // 添加用户角色
    public void assignUserRole(String userId, Long roleId) {
        User user = getUser(userId);
        if (user != null) {
            Role role = getRole(roleId);
            if (role != null) {
                user.addRole(role);
                List<Role> userRoles = rolesFromUser.computeIfAbsent(userId, k -> new ArrayList<>());
                userRoles.add(role);
                List<User> roleUsers = usersFromRole.computeIfAbsent(roleId, k -> new ArrayList<>());
                roleUsers.add(user);
            }
        }
    }


    // 通过用户ID，得到对应的所有角色
    public List<Role> getUserRoles(String userId) {
        return rolesFromUser.getOrDefault(userId, new ArrayList<>());
    }

    // 通过角色ID，得到对应的用户
    public List<User> getRoleUsers(Long roleId) {
        return usersFromRole.getOrDefault(roleId, new ArrayList<>());
    }

    // 将指定的角色分配给指定的权限，并将角色添加到拥有此权限的角色列表中。
    public void assignAuthorityRole(Long roleId, Long authId, String info) {
        Role role = getRole(roleId);
        if (role != null) {
            Authority authority = new Authority(authId, info, info);
            role.addAuthority(authority);
            List<Role> authorityRoles = rolesFromAuthority.computeIfAbsent(authId, k -> new ArrayList<>());
            authorityRoles.add(role);
        }
    }

    // 通过权限ID 获取对应的所有角色
    public List<Role> getAuthorityRoles(Long authId) {
        return rolesFromAuthority.getOrDefault(authId, new ArrayList<>());
    }


    // 根据权限，加入到对应的用户中
    public void assignPermissionUser(String userId, Long authId) {
        User user = getUser(userId);
        if (user != null) {
            Authority authority = new Authority(authId);
            List<Role> userRoles = user.getRoles();
            for (Role role : userRoles) {
                role.addAuthority(authority);
                List<User> authorityUsers = usersFromAuthority.computeIfAbsent(authId, k -> new ArrayList<>());
                authorityUsers.add(user);
            }
        }
    }


    // 根据权限ID 得到对应的用户
    public List<User> getAuthorityUsers(Long authId) {
        return usersFromAuthority.getOrDefault(authId, new ArrayList<>());
    }

    // 通过用户ID，得到所有的权限
    public List<Authority> getUsersAuthority(String userId) {
        List<Authority> res = new ArrayList<>();
        User myuser = users.get(userId);
        if (myuser != null) {
            // 获取所有的角色
            List<Role> roles = myuser.getRoles();
            // 获取所有的权限
            for (int i = 0; i < roles.size(); i++) {
                List<Authority> temp = roles.get(i).getAuthorities();
                for (int k = 0; k < temp.size(); k++) {
                    res.add(temp.get(k));
                }
            }
        }
        return res;
    }
}

public class h1 {
    public static void main(String[] args) {

        Management management = new Management();
        User user1 = new User("110", "RW", "123456", (short) 1);
        management.addUser(user1);

        Role role1 = new Role(1, "游客", "我是游客");
        Role role2 = new Role(2, "管理员", "我是管理员");

        management.addRole(role1);
        management.addRole(role2);
        Authority permission1 = new Authority(1l, "打开文件", "打开文件");
        Authority permission2 = new Authority(2l, "删除文件", "删除文件");
        Authority permission3 = new Authority(3l, "拷贝文件", "拷贝文件");
        Authority permission4 = new Authority(4l, "修改文件", "修改文件");
        management.assignUserRole("110", 1l);
        management.assignUserRole("110", 2l);
        management.assignAuthorityRole(1l, 1l, "打开文件");
        management.assignAuthorityRole(2l, 4l, "修改文件");

        // 获取用户的角色和权限
        User user = management.getUser("110");
        List<Role> roles = user.getRoles();
        for (Role role : roles) {
            System.out.println("角色ID：" + role.getRoleId());
            List<Authority> permissions = role.getAuthorities();
            for (Authority authority : permissions) {
                System.out.println("权限ID：" + authority.authId + "  " + authority.info);
            }
        }
        //        角色ID：1
        //        权限ID：1  打开文件
        //        角色ID：2
        //        权限ID：4  修改文件

    }

}
