package org.pjpjcute.stockforecast.core.infrastructure.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@Entity
@Table(name = "users")
public class UserDo {

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long   id;

    /**
     * userName
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * password
     */
    @Column(nullable = false)
    private String password;

    /**
     * email
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Preferences
     */
    @Column
    private String stockPreferences;

}
