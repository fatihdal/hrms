package com.dalfatih.hrms.entities.concretes;

import java.util.Arrays;


public enum Gender {
    MAN("MAN"),
    WOMAN("WOMAN");

    private String value;

    Gender(String value) {
        this.value = value;
    }

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


