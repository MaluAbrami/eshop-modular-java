package org.eshop.eshop.user.application.services;

import org.eshop.eshop.user.application.command.CreateUserCommand;
import org.eshop.eshop.user.application.result.UserResult;
import org.eshop.eshop.user.domain.entities.User;
import org.eshop.eshop.user.domain.repository.IUserRepository;
import org.eshop.eshop.user.domain.valueObjects.Email;
import org.eshop.eshop.user.domain.valueObjects.Password;
import org.springframework.stereotype.Component;

@Component
public class CreateUserService {
    private final IUserRepository userRepository;

    public CreateUserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResult execute(CreateUserCommand command) {
        userRepository.findByEmail(command.email()).ifPresent(u -> {
            throw new IllegalArgumentException("Email já cadastrado");
        });

        var user = User.createNew(
                command.name(),
                new Email(command.email()),
                new Password(command.password())
        );

        var newUser = userRepository.save(user);

        return new UserResult(newUser.getId(), newUser.getName(), newUser.getEmail());
    }
}
