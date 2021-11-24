package com.javafee.pjatk.utils.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PowerTrainType {
	GASOLINE("gasoline"), DIESEL("diesel"), HYBRID("hybrid"), ELECTRIC("electric"),
	OXYGEN("oxygen"), GAS("gas");

	private final String name;

	public static PowerTrainType getByName(String name) {
		return Arrays.stream(PowerTrainType.values()).filter(e -> e.name.equals(name)).findFirst().orElse(null);
	}
}
