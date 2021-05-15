package com.dalfatih.hrms.utils;

import com.dalfatih.hrms.entities.concretes.Gender;
import com.dalfatih.hrms.entities.concretes.Role;
import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter<String, Gender> {
    @Override
    public Gender convert(String source) {
        return Gender.valueOf(source.toUpperCase());
    }
}