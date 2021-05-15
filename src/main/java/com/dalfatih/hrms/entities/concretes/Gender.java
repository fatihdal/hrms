package com.dalfatih.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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
                "asgsdhashashUnknown enum type " + value + ", adgasshaAllowed values are " + Arrays.toString(values()));
    }
}


