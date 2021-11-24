package com.javafee.pjatk.utils.enums;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ThingType {
	ITEM("item"), AMPHIBIOUS("amphibious"), BOAT("boat"), CITY_CAR("city-car"),
	MOTORCYCLE("motorcycle"), OFF_ROAD_CAR("offroad-car");

	private final String name;

	public static ThingType getByName(String name) {
		return Arrays.stream(ThingType.values()).filter(e -> e.name.equals(name)).findFirst().orElse(null);
	}
}
