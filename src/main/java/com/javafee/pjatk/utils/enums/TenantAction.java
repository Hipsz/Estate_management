package com.javafee.pjatk.utils.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum TenantAction {
    DISPLAY_EMPTY_FLATS(1), RENT(2), DISPLAY_DATA(3), ADD_PERSON(4),
    ADD_ITEM_OR_VEHICLE(5), REMOVE_ITEM_OR_VEHICLE(6);

    private final int number;

    public static TenantAction getByNumber(int number) {
        return Arrays.stream(TenantAction.values()).filter(e -> e.number == number).findFirst().orElse(null);
    }
}
