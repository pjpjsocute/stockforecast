package org.pjpjcute.stockforecast.core.controller;

import java.util.Set;

import org.pjpjcute.stockforecast.api.reponse.Result;
import org.pjpjcute.stockforecast.api.reponse.user.model.UserDto;
import org.pjpjcute.stockforecast.api.request.user.cmd.RegistrationRequest;
import org.pjpjcute.stockforecast.core.application.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result<UserDto> registerUser(@RequestBody RegistrationRequest request) {
        UserDto user = userService.registerNewUser(request.getUserName(), request.getPassword(), request.getEmail());
        return Result.success(user);
    }

    @PutMapping("/{userId}/preferences")
    public Result<UserDto> updateUserPreferences(@PathVariable Long userId, @RequestBody Set<String> preferences) {
        UserDto updatedUser = userService.updateUserPreferences(userId, preferences);
        return Result.success(updatedUser);
    }
}
