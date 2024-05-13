package com.ssy.users;

import com.ssy.users.entities.Role;
import com.ssy.users.entities.User;
import com.ssy.users.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MicroUsersApplication {

    @Autowired
    UserService userService;
    public static void main(String[] args) {
        SpringApplication.run(MicroUsersApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }


   /* @PostConstruct
    void init_users(){
        // ajout roles
        userService.addRole(new Role(null,"ADMIN"));
        userService.addRole(new Role(null,"USER"));

        //ajout users
        userService.saveUser(new User(null,"admin","123",true,null));
        userService.saveUser(new User(null,"sidy","123",true,null));
        userService.saveUser(new User(null,"ssy","123",true,null));

        //ajout role to users

        userService.addRoleToUser("admin","ADMIN");
        userService.addRoleToUser("admin","USER");
        userService.addRoleToUser("sidy","USER");
        userService.addRoleToUser("ssy","USER");

    }*/
}
