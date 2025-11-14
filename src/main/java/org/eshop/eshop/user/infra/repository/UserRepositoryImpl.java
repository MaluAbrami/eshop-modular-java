package org.eshop.eshop.user.infra.repository;

import jakarta.transaction.Transactional;
import org.eshop.eshop.user.domain.entities.User;
import org.eshop.eshop.user.domain.repository.IUserRepository;
import org.eshop.eshop.user.domain.valueObjects.Email;
import org.eshop.eshop.user.domain.valueObjects.Password;
import org.eshop.eshop.user.infra.entity.UserJpaEntity;
import org.eshop.eshop.user.infra.jpa.IUserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepositoryImpl implements IUserRepository {
    private final IUserJpaRepository jpa;

    public UserRepositoryImpl(IUserJpaRepository jpa) {
        this.jpa = jpa;
    }

    @Override
    @Transactional
    public User save(User user) {
        var entity = new UserJpaEntity(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );

        var saved = jpa.save(entity);

        return User.withId(
                saved.getId(),
                saved.getName(),
                new Email(saved.getEmail()),
                new Password(saved.getPassword())
        );
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpa.findById(id).map(e ->
                User.withId(
                        e.getId(),
                        e.getName(),
                        new Email(e.getEmail()),
                        new Password(e.getPassword())
                )
        );
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpa.findUserJpaEntitiesByEmail(email).map(e ->
                User.withId(
                        e.getId(),
                        e.getName(),
                        new Email(e.getEmail()),
                        new Password(e.getPassword())
                )
        );
    }
}
