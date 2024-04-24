package org.pjpjcute.stockforecast.core.infrastructure.persistence.mapper;

import org.pjpjcute.stockforecast.core.infrastructure.persistence.model.UserDo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhoulei
 * @create 2024/4/24
 * @description:
 */
public interface UserMapper extends JpaRepository<UserDo, Long> {
}
