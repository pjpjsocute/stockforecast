package org.pjpjcute.stockforecast.core.domain.user;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public interface UserRepository {

    /**
     * create
     * 
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * selectBy id
     * 
     * @param
     * @return
     */
    User selectById(Long id);
}
