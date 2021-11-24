package com.javafee.pjatk.utils;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;

@UtilityClass
public class SystemProperties {
    private int TOTAL_NUMBER_OF_RENTS;
    private int RENEWAL_DAYS;
    private LocalDate APP_DATE_TIME = LocalDate.now();
}
