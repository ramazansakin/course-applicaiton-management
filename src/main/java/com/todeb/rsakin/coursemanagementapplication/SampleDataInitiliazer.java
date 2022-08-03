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

@Component
@RequiredArgsConstructor
public class SampleDataInitiliazer implements ApplicationRunner {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) {

        Role adminRole = new Role();
        adminRole.setRoleName("ROLE_ADMIN");
        Role clientRole = new Role();
        clientRole.setRoleName("ROLE_CLIENT");

        // Creating ADMIN & USER roles
        if (!roleRepository.existsByRoleName(adminRole.getRoleName())) {
            roleRepository.save(adminRole);
        }
        if (!roleRepository.existsByRoleName(clientRole.getRoleName())) {
            roleRepository.save(clientRole);
        }

        // Creating a sample Admin USER
        User adminUser = new User("admin-user", "adminuser@mail.com", "pass1234");

        if (adminUser.getUsername() != null && !adminUser.getUsername().isEmpty()) {
            // @NotNull && @NotEmpty = @NotBlank
        }

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
