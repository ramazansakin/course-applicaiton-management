package com.todeb.rsakin.coursemanagementapplication.controller;


import com.todeb.rsakin.coursemanagementapplication.model.dto.UserDataDTO;
import com.todeb.rsakin.coursemanagementapplication.model.dto.UserLoginDTO;
import com.todeb.rsakin.coursemanagementapplication.model.entity.User;
import com.todeb.rsakin.coursemanagementapplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PreAuthorize("hasRole('ADMIN') OR hasRole('USER')")
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PostMapping("/signin")
    public String login(@Valid @RequestBody UserLoginDTO userLoginDTO) {
        return userService.signin(userLoginDTO.getUsername(), userLoginDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserDataDTO userDataDTO) {
        User user = new User();
        user.setUsername(userDataDTO.getUsername());
        user.setEmail(userDataDTO.getEmail());
        user.setPassword(userDataDTO.getPassword());
//        return userService.signup(modelMapper.map(user, User.class));
        return userService.signup(user);
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RolesAllowed("ROLE_ADMIN")
    @DeleteMapping(value = "/delete/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

//    @GetMapping(value = "/me")
//    public UserResponseDTO whoami(HttpServletRequest req) {
//
//        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
//    }

}
