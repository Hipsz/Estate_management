package com.javafee.pjatk.utils.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum LandlordAction {
	ADD_ESTATE(1), SAVE(2);

	private final int number;

	public static LandlordAction getByNumber(int number) {
		return Arrays.stream(LandlordAction.values()).filter(e -> e.number == number).findFirst().orElse(null);
	}
}
