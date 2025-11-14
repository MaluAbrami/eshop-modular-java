package org.eshop.eshop.user.infra.jpa;

import org.eshop.eshop.user.infra.entity.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID>
{
    Optional<UserJpaEntity> findUserJpaEntitiesByEmail(String email);
}
