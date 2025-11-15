package org.eshop.eshop.user.application.result;

import java.util.UUID;

public record UserResult(UUID id, String name, String email) {
}
