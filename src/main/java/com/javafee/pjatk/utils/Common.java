package com.javafee.pjatk.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class Common {
    public LocalDate ofNextYear(LocalDate localDate, int numberOfYears) {
        return LocalDate.of(localDate.getYear() + numberOfYears, localDate.getMonth(), localDate.getDayOfMonth());
    }
}
