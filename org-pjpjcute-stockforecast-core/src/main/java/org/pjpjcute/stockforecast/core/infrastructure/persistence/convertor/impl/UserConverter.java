package org.pjpjcute.stockforecast.core.infrastructure.persistence.convertor.impl;

import org.pjpjcute.stockforecast.core.domain.user.User;
import org.pjpjcute.stockforecast.core.infrastructure.persistence.convertor.BaseConverter;
import org.pjpjcute.stockforecast.core.infrastructure.persistence.model.UserDo;
import org.springframework.stereotype.Component;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
@Component
public class UserConverter implements BaseConverter<User, UserDo> {
    @Override
    public User convert2Obj(UserDo doObj) {
        return null;
    }

    @Override
    public UserDo convert2DO(User domainObj) {
        return null;
    }
}
