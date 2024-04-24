package org.pjpjcute.stockforecast.api.request.user.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationRequest {

    /**
     * user name
     */
    private String userName;

    /**
     * password
     */
    private String password;

    /**
     * email
     */
    private String email;
}
