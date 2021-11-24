package com.javafee.pjatk.utils;

import java.util.ArrayList;
import java.util.List;

import com.javafee.pjatk.model.BlockOfFlats;
import com.javafee.pjatk.model.Estate;
import com.javafee.pjatk.model.Flat;
import com.javafee.pjatk.model.Parking;
import com.javafee.pjatk.model.Person;
import com.javafee.pjatk.utils.enums.Role;

import lombok.experimental.UtilityClass;

@UtilityClass
public class DataProvider {
	public List<Person> PEOPLE = new ArrayList<>();
	public List<Estate> ESTATES = new ArrayList<>();

	static {
		feedPeople();
		feedEstates();
	}

	public void feedPeople() {
		PEOPLE.add(Person.builder().id(IdGenerator.getId()).role(Role.LANDLORD).name("Jan").surname("Kowalski")
				.address("ul. Glowna 17/2, Warszawa").pesel("15059119217").build());
		PEOPLE.add(Person.builder().id(IdGenerator.getId()).role(Role.LANDLORD).name("Anna").surname("Kaminska")
				.address("ul. 3-go Maja 11, Kalisz").build());
		PEOPLE.add(Person.builder().id(IdGenerator.getId()).role(Role.TENANTS).name("Miroslaw").surname("Biger")
				.address("ul. Poznanska 1, Knurow").pesel("11028881721").build());
		PEOPLE.add(Person.builder().id(IdGenerator.getId()).role(Role.TENANTS).name("Grzegorz").surname("Nowak")
				.address("ul. Pszczynska 123/23, Gliwice").build());
	}

	public void feedEstates() {
		ESTATES.add(Estate.builder().name("Miasteczko Wilanow").blockOfFlats(
				List.of(createBlockOfFlats("Blok 14", List.of(createFlat(55.0, null), createFlat(38.0, createParking(25.0)))),
						createBlockOfFlats("Blok 2", List.of(createFlat(115.0, createParking(35.0)), createFlat(160.0, createParking(25.0)))),
						createBlockOfFlats("Blok 7", List.of(createFlat(20.0, null), createFlat(40.0, createParking(20.0)))))
		).build());
		ESTATES.add(Estate.builder().name("Osiedle Tysiaclecia").blockOfFlats(
				List.of(createBlockOfFlats("Blok 116", List.of(createFlat(20.0, null), createFlat(20.0, null), createFlat(25.0, null))),
						createBlockOfFlats("Blok 200", List.of(createFlat(35.0, createParking(20.0)), createFlat(40.0, createParking(20.0)), createFlat(40.0, null))))
		).build());
	}

	public BlockOfFlats createBlockOfFlats(String name, List<Flat> flats) {
		return BlockOfFlats.builder().name(name).flats(flats).build();
	}

	public Flat createFlat(Double capacity, Parking parking) {
		return Flat.builder().id(IdGenerator.getId()).capacity(capacity).parking(parking).people(new ArrayList<>()).build();
	}

	public Parking createParking(Double capacity) {
		return Parking.builder().id(IdGenerator.getId()).capacity(capacity).things(new ArrayList<>()).build();
	}
}
