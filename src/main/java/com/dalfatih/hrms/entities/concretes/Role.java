package com.dalfatih.hrms.entities.concretes;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum Role {

    ADMIN("ADMIN"),
    USER("USER");

    private String value;

    public static Role fromValue(String value) {
        for (Role role : values()) {
            if (role.value.equalsIgnoreCase(value)) {
                return role;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}