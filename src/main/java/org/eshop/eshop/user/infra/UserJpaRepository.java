package org.eshop.eshop.user.infra;

import org.eshop.eshop.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<User, UUID>
{
}
