package org.eshop.eshop.user.domain.valueObjects;

public record Email(String value) {
    public Email {
        if(value == null || !value.matches("^(.+)@(.+)$")){
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    @Override
    public String toString() {
        return value;
    }
}
