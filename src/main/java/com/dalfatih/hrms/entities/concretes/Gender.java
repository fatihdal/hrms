package com.dalfatih.hrms.entities.concretes;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public enum Gender {
    MAN("MAN"),
    WOMAN("WOMAN");

    private String value;

    public static Gender fromValue(String value) {
        for (Gender category : values()) {
            if (category.value.equalsIgnoreCase(value)) {
                return category;
            }
        }
        throw new IllegalArgumentException(
                "Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
    }
}