package com.ssy.users.service;

import com.ssy.users.entities.Role;
import com.ssy.users.entities.User;

public interface UserService {
    User saveUser (User user);
    User findUserByUsername( String username);
    Role addRole (Role role);
    User addRoleToUser (String username, String rolename);
}
