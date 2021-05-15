package com.dalfatih.hrms.entities.concretes;

public enum Gender {
    MAN(1),
    WOMAN(2);

    int genderNum;

    Gender(int genderNum) {
        this.genderNum = genderNum;
    }

    public int getGenderNum() {
        return genderNum;
    }

    public void setGenderNum(int genderNum) {
        this.genderNum = genderNum;
    }
}
