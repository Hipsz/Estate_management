package com.javafee.pjatk.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IdGenerator {
    private int generator = 1;

    public int getId() {
        return generator++;
    }
}
