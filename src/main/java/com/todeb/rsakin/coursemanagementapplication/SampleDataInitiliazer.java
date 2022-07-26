package com.todeb.rsakin.coursemanagementapplication;

import com.todeb.rsakin.coursemanagementapplication.model.entity.User;
import com.todeb.rsakin.coursemanagementapplication.repository.UserRepository;
import com.todeb.rsakin.coursemanagementapplication.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {

    //    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) {

//        Role adminRole = new Role();
//        adminRole.setName("ROLE_ADMIN");
//        Role userRole = new Role();
//        userRole.setName("ROLE_USER");
//
//        // Creating ADMIN & USER roles
//        if (!roleRepository.existsByName(adminRole.getName())) {
//            roleRepository.save(adminRole);
//        }
//        if (!roleRepository.existsByName(userRole.getName())) {
//            roleRepository.save(userRole);
//        }

        // Creating a sample Admin USER
        User adminUser = new User("admin-user", "adminuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(adminUser.getUsername())) {
            userService.signup(adminUser, true);
        }

        // Creating a sample USER
        User sampleUser = new User("sample-user", "sampleuser@mail.com", "pass1234");
        if (!userRepository.existsByUsername(sampleUser.getUsername())) {
            userService.signup(sampleUser, false);
        }

    }

}
