package com.todeb.rsakin.coursemanagementapplication;

import com.todeb.rsakin.coursemanagementapplication.model.entity.Role;
import com.todeb.rsakin.coursemanagementapplication.model.entity.User;
import com.todeb.rsakin.coursemanagementapplication.repository.RoleRepository;
import com.todeb.rsakin.coursemanagementapplication.repository.UserRepository;
import com.todeb.rsakin.coursemanagementapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role adminRole = new Role();
        adminRole.setId(1);
        adminRole.setRole_name("ADMIN");
        Role userRole = new Role();
        userRole.setId(2);
        userRole.setRole_name("USER");

        if (!roleRepository.existsById(adminRole.getId())) {
            roleRepository.save(adminRole);
        }
        if (!roleRepository.existsById(userRole.getId())) {
            roleRepository.save(userRole);
        }

        // Creating a sample ADMIN user
        User adminUser = new User(3, "admin-user", "admin@mail.com", "pass12345",
                Arrays.asList(adminRole));
        if (!userRepository.existsById(adminUser.getId())) {
            userRepository.save(adminUser);
        }

        User adminUser2 = new User(7, "admin-user2", "admin2@mail.com", "pass12345",
                Arrays.asList(adminRole));
        if (!userRepository.existsById(adminUser2.getId())) {
            userService.signup(adminUser2);
        }

    }

}
