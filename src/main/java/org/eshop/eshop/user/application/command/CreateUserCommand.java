package org.eshop.eshop.user.application.command;

public record CreateUserCommand(String name, String email, String password) {
    public CreateUserCommand {
        if (name == null) {
            throw new IllegalArgumentException("Nome é obrigatório");
        }
    }
}
