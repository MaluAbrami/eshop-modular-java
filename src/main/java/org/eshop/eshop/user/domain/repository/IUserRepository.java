package org.eshop.eshop.user.domain.repository;

import org.eshop.eshop.user.domain.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface IUserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
}
