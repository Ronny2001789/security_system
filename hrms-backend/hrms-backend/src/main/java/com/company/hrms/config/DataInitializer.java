package com.company.hrms.config;

import com.company.hrms.user.User;
import com.company.hrms.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) {
        if (userService.existsByUsername("admin")) return;

        userService.createUser("admin", "admin123", User.Role.ADMIN);
        userService.createUser("hr", "hr123", User.Role.HR);
        userService.createUser("employee", "emp123", User.Role.EMPLOYEE);

        System.out.println("✅ Default users created");
    }
}
