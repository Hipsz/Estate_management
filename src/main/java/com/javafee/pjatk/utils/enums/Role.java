package com.javafee.pjatk.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Role {
    LANDLORD("wynajmujacy"), TENANTS("najemca");

    private String name;

    public Role getByName(String name) {
        return Arrays.stream(Role.values()).filter(e -> name.equals(e.name)).findFirst().orElse(null);
    }
}
