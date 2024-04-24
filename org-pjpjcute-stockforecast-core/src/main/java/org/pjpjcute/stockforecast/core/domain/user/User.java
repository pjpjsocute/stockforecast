package org.pjpjcute.stockforecast.core.domain.user;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections4.SetUtils;
import org.pjpjcute.stockforecast.core.domain.user.model.StockPreference;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    /**
     * id
     */
    private Long                 id;

    /**
     * userName
     */
    private String               username;

    /**
     * password
     */
    private String               password;

    /**
     * email
     */
    private String               email;

    /**
     * Preferences
     */
    private Set<StockPreference> stockPreferences = new HashSet<>();

    public static User
        createUser(String username, String password, String email, Set<StockPreference> stockPreferences) {
        User user = new User();
        user.username = username;
        user.password = password;
        user.email = email;
        user.stockPreferences = SetUtils.emptyIfNull(stockPreferences);
        return user;
    }

    public static User
        buildUser(Long id, String username, String password, String email, Set<StockPreference> stockPreferences) {
        User user = new User();
        user.username = username;
        user.password = password;
        user.email = email;
        user.id = id;
        user.stockPreferences = SetUtils.emptyIfNull(stockPreferences);
        return user;
    }

}
