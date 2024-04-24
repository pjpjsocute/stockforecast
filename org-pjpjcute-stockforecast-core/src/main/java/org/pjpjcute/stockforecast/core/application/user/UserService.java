package org.pjpjcute.stockforecast.core.application.user;

import java.util.Set;

import org.pjpjcute.stockforecast.api.reponse.user.model.UserDto;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public interface UserService {

    /**
     * register user
     * 
     * @param userName
     * @param password
     * @param email
     * @return
     */
    UserDto registerNewUser(String userName, String password, String email);

    /**
     * update Preference
     * @param userId
     * @param preferences
     * @return
     */
    UserDto updateUserPreferences(Long userId, Set<String> preferences);
}
