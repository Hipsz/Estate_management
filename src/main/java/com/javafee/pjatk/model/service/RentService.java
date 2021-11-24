package com.javafee.pjatk.model.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.javafee.pjatk.model.BlockOfFlats;
import com.javafee.pjatk.model.Estate;
import com.javafee.pjatk.model.Flat;
import com.javafee.pjatk.model.Parking;
import com.javafee.pjatk.model.Person;
import com.javafee.pjatk.model.Rent;
import com.javafee.pjatk.model.thing.Thing;
import com.javafee.pjatk.utils.Common;
import com.javafee.pjatk.utils.DataProvider;
import com.javafee.pjatk.utils.IdGenerator;
import com.javafee.pjatk.utils.exceptions.NoSuchFlatException;
import com.javafee.pjatk.utils.exceptions.NoSuchParkingException;
import com.javafee.pjatk.utils.exceptions.NoSuchThingException;

public class RentService {
	private List<Rent> rents = new ArrayList<>();


	public Rent rent(int flatId, Person person) {
		/* Person update */
		person.setCheckedIn(Boolean.TRUE);
		/* Flat update */
		Flat flat = findFlatById(flatId);
		flat.setTenant(person);
		/* Rent creation */
		return Rent.builder().id(IdGenerator.getId()).flats(List.of(flat)).tenant(person)
				.rentStartDate(LocalDate.now())
				.rentEndDate(Common.ofNextYear(LocalDate.now(), 1)).build();
	}

	public Rent renew(Rent rent) {
		return null;
	}

	public Rent cancel(Rent rent) {
		return null;
	}

	public void addPerson(Person person, int flatId, Person personToAdd) throws NoSuchFlatException {
		findPersonsFlatByFlatId(person, flatId).getPeople().add(personToAdd);
	}

	public void addThing(Person person, int parkingId, Thing thingToAdd) throws NoSuchParkingException, NoSuchFlatException {
		findPersonsParkingByParkingId(person, parkingId).getThings().add(thingToAdd);
	}

	public void removeThing(Person person, int parkingId, int thingId) throws NoSuchParkingException, NoSuchFlatException, NoSuchThingException {
		Parking parking = findPersonsParkingByParkingId(person, parkingId);
		parking.getThings().remove(findThingById(parking, thingId));
	}

	public Flat findPersonsFlatByFlatId(Person person, int flatId) throws NoSuchFlatException {
		List<Flat> personsFlat = findFlatByPerson(person);
		Flat flat;
		if (!personsFlat.isEmpty()) {
			flat = personsFlat.stream().filter(e -> e.getId() == flatId).findFirst()
					.orElseThrow(() -> new NoSuchFlatException("Użytkownik nie posiada mieszkania o zadanym ID = " + flatId));
		} else
			throw new NoSuchFlatException("Użytkownik nie posiada wynajętych mieszkań");
		return flat;
	}

	public List<Flat> findFlatByPerson(Person person) {
		List<Flat> personsFlat = new ArrayList<>();
		DataProvider.ESTATES.forEach(estate -> estate.getBlockOfFlats().forEach(blockOfFlats -> blockOfFlats.getFlats().forEach(flat -> {
			Optional<Person> tenant = Optional.ofNullable(flat.getTenant());
			if (tenant.isPresent() && tenant.get().getId() == person.getId())
				personsFlat.add(flat);
		})));
		return personsFlat;
	}

	public Flat findFlatById(int id) {
		for (Estate estate : DataProvider.ESTATES)
			for (BlockOfFlats blockOfFlats : estate.getBlockOfFlats())
				for (Flat flat : blockOfFlats.getFlats())
					if (flat.getId() == id)
						return flat;
		return null;
	}

	public List<Flat> findEmptyFlats() {
		List<Flat> emptyFlats = new ArrayList<>();
		DataProvider.ESTATES.forEach(estate -> estate.getBlockOfFlats().forEach(blockOfFlats -> blockOfFlats.getFlats().forEach(flat -> {
			if (Optional.ofNullable(flat.getTenant()).isEmpty())
				emptyFlats.add(flat);
		})));
		return emptyFlats;
	}

	public Parking findPersonsParkingByParkingId(Person person, int parkingId) throws NoSuchFlatException, NoSuchParkingException {
		List<Flat> personsFlat = findFlatByPerson(person);
		Parking parking;
		if (!personsFlat.isEmpty()) {
			parking = personsFlat.stream().filter(e -> e.getParking() != null && e.getParking().getId() == parkingId).findFirst()
					.orElseThrow(() -> new NoSuchParkingException("Użytkownik nie posiada parkingu o zadanym ID = " + parkingId)).getParking();
		} else
			throw new NoSuchFlatException("Użytkownik nie posiada wynajętych mieszkań");
		return parking;
	}

	public Thing findThingById(Parking parking, int thingId) throws NoSuchThingException {
		return parking.getThings().stream().filter(e -> e.getId() == thingId).findFirst()
				.orElseThrow(() -> new NoSuchThingException("Użytkownik nie posiada przedmiotu o zadanym ID = " + thingId));
	}
}
