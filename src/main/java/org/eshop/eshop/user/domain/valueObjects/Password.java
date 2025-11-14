package org.eshop.eshop.user.domain.valueObjects;

public record Password(String hashedValue) {
    public Password {
        if(hashedValue == null || hashedValue.isBlank()) {
            throw new IllegalArgumentException("Password cannot be empty");
        }
    }

    @Override
    public String toString() {
        return hashedValue;
    }
}
