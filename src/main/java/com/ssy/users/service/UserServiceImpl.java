package com.ssy.users.service;

import com.ssy.users.entities.Role;
import com.ssy.users.entities.User;
import com.ssy.users.repos.RoleRepository;
import com.ssy.users.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
         return userRepository.save(user);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role addRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User addRoleToUser(String username, String rolename) {

        User usr = userRepository.findByUsername(username);
        Role role = roleRepository.findByRole(rolename);

        usr.getRoles().add(role);
        //userRepository.save(usr);
        return usr;
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
