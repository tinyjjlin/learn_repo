package com.beruosi.oav1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;

@SpringBootApplication
@EnableLdapRepositories
public class Oav1Application {

    public static void main(String[] args) {
        SpringApplication.run(Oav1Application.class, args);
    }
}
