package com.todeb.rsakin.coursemanagementapplication.service;

import com.todeb.rsakin.coursemanagementapplication.exception.CustomJwtException;
import com.todeb.rsakin.coursemanagementapplication.model.entity.Role;
import com.todeb.rsakin.coursemanagementapplication.model.entity.User;
import com.todeb.rsakin.coursemanagementapplication.repository.UserRepository;
import com.todeb.rsakin.coursemanagementapplication.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

//    private final RoleRepository roleRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;

    private final AuthenticationManager authenticationManager;

    //    @PostConstruct
//    private void postConstruct() {
//        // Sample test admin user insert
//        User admin = new User();
//        admin.setUsername("admin-rmzn");
//        admin.setPassword("pass12345");
//        admin.setEmail("admin@email.com");
//        admin.setRoles(Collections.singletonList(roleRepository.getById(1)));
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
//        userRepository.save(admin);
//    }
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public String signin(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
            return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
        } catch (AuthenticationException e) {
            throw new CustomJwtException("Invalid username/password supplied", HttpStatus.BAD_REQUEST);
        }
    }

    public String signup(User user, boolean isAdmin) {
        if (!userRepository.existsByUsername(user.getUsername())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
//          Optional<Role> relatedRole = roleRepository.findByName(isAdmin ? "ROLE_ADMIN" : "ROLE_USER");
            Role role = isAdmin ? Role.ROLE_ADMIN : Role.ROLE_CLIENT;
            user.setRoles(Collections.singleton(role));
            userRepository.save(user);
            return jwtTokenProvider.createToken(user.getUsername(), user.getRoles());
        } else {
            throw new CustomJwtException("Username is already in use", HttpStatus.BAD_REQUEST);
        }
    }

    public void delete(String username) {
        if (userRepository.existsByUsername(username)) {
            userRepository.deleteByUsername(username);
        } else {
            throw new CustomJwtException("Username is not found", HttpStatus.NOT_FOUND);
        }
    }

    public User search(String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new CustomJwtException("The user doesn't exist", HttpStatus.NOT_FOUND);
        }
        return user;
    }

    public User whoami(HttpServletRequest req) {
        return userRepository.findByUsername(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
    }

    public String refresh(String username) {
        return jwtTokenProvider.createToken(username, userRepository.findByUsername(username).getRoles());
    }

}
