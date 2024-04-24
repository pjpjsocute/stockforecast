package org.pjpjcute.stockforecast.core.infrastructure.persistence.repository;

import org.pjpjcute.stockforecast.core.domain.user.User;
import org.pjpjcute.stockforecast.core.domain.user.UserRepository;
import org.pjpjcute.stockforecast.core.infrastructure.persistence.convertor.impl.UserConverter;
import org.pjpjcute.stockforecast.core.infrastructure.persistence.mapper.UserMapper;
import org.pjpjcute.stockforecast.core.infrastructure.persistence.model.UserDo;
import org.springframework.stereotype.Repository;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserMapper    userMapper;

    private final UserConverter userConverter;

    public UserRepositoryImpl(UserMapper userMapper, UserConverter userConverter) {
        this.userMapper = userMapper;
        this.userConverter = userConverter;
    }

    @Override
    public User createUser(User user) {
        UserDo save = userMapper.save(userConverter.convert2DO(user));
        return userConverter.convert2Obj(save);
    }

    @Override
    public User selectById(Long id) {
        return null;
    }

}
