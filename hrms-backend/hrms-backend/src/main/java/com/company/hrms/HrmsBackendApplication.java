package com.company.hrms;

import com.company.hrms.user.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class HrmsBackendApplication {

    private final UserService userService;

    public HrmsBackendApplication(UserService userService) {
        this.userService = userService;
    }

    public static void main(String[] args) {
        SpringApplication.run(HrmsBackendApplication.class, args);
    }
}



