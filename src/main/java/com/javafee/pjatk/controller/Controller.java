package com.javafee.pjatk.controller;

import java.io.IOException;
import java.util.Optional;

import com.javafee.pjatk.model.Person;
import com.javafee.pjatk.model.service.RentService;
import com.javafee.pjatk.model.service.UserService;
import com.javafee.pjatk.model.thing.Thing;
import com.javafee.pjatk.model.thing.item.Item;
import com.javafee.pjatk.model.thing.vehilce.Amphibious;
import com.javafee.pjatk.model.thing.vehilce.Boat;
import com.javafee.pjatk.model.thing.vehilce.CityCar;
import com.javafee.pjatk.model.thing.vehilce.Motorcycle;
import com.javafee.pjatk.model.thing.vehilce.OffRoadCar;
import com.javafee.pjatk.utils.DataProvider;
import com.javafee.pjatk.utils.FileService;
import com.javafee.pjatk.utils.IdGenerator;
import com.javafee.pjatk.utils.enums.LandlordAction;
import com.javafee.pjatk.utils.enums.PowerTrainType;
import com.javafee.pjatk.utils.enums.TenantAction;
import com.javafee.pjatk.utils.enums.ThingType;
import com.javafee.pjatk.utils.exceptions.NoSuchFlatException;
import com.javafee.pjatk.utils.exceptions.NoSuchParkingException;
import com.javafee.pjatk.utils.exceptions.NoSuchThingException;
import com.javafee.pjatk.utils.exceptions.NoSuchUserException;
import com.javafee.pjatk.view.View;



public class Controller {
	/* View layer class dependencies */
	private View view = new View();

	/* Model layer class dependencies */
	private UserService userService = new UserService();
	private RentService rentService = new RentService();
	private FileService fileService = new FileService();

	/* Other */
	private Person currentUser;

	public void start() {
		int choice = 1;

		performLogin();

		while (choice != 0) {
			switch (currentUser.getRole()) {
				case LANDLORD -> {
					performLandlordActions(view.displayLandlordMenu());
				}
				case TENANTS -> {
					performTenantsActions(view.displayTenantsMenu());
				}
			}
		}
	}

	private void performLandlordActions(int choice) {
		switch (LandlordAction.getByNumber(choice)) {
			case ADD_ESTATE -> {

			}
			case SAVE -> {
				try {
					fileService.save(DataProvider.ESTATES);
				} catch (IOException e) {
					view.displayError(e.getMessage());
				}
			}
		}
	}

	private void performTenantsActions(int choice) {
		switch (TenantAction.getByNumber(choice)) {
			case DISPLAY_EMPTY_FLATS -> {
				rentService.findEmptyFlats().forEach(System.out::println);
			}
			case RENT -> {
				Optional.ofNullable(rentService.rent(view.getFlatId(), currentUser))
						.ifPresent(e -> view.displayRentSuccess(e.getId(), e.getRentEndDate()));
			}
			case DISPLAY_DATA -> {
				StringBuilder userDataString = new StringBuilder();
				userDataString.append(currentUser).append("\n");
				rentService.findFlatByPerson(currentUser).forEach(e -> userDataString.append(e).append("\n"));
				view.displayUserData(userDataString.toString());
			}
			case ADD_PERSON -> {
				try {
					rentService.addPerson(currentUser, view.getFlatId(), userService.findById(view.getPersonId()));
				} catch (NoSuchFlatException | NoSuchUserException e) {
					view.displayError(e.getMessage());
				}
			}
			case ADD_ITEM_OR_VEHICLE -> {
				Optional<ThingType> thingType = Optional.ofNullable(ThingType.getByName(view.getThingType()));
				if (thingType.isEmpty()) view.displayError("Brak przedmiotu o podanym typie");
				else {
					try {
						rentService.addThing(currentUser, view.getParkingId(), performThingCreation(thingType));
					} catch (NoSuchFlatException | NoSuchParkingException e) {
						view.displayError(e.getMessage());
					}
				}
			}
			case REMOVE_ITEM_OR_VEHICLE -> {
				try {
					rentService.removeThing(currentUser, view.getParkingId(), view.getThingId());
				} catch (NoSuchFlatException | NoSuchParkingException | NoSuchThingException e) {
					view.displayError(e.getMessage());
				}
			}
		}
	}

	private Thing performThingCreation(Optional<ThingType> thingType) {
		Thing thing = null;
		switch (thingType.get()) {
			case ITEM -> thing = new Item(IdGenerator.getId(), view.getName(), view.getSurface());
			case AMPHIBIOUS -> {

				Optional<PowerTrainType> powerTrainType = Optional.ofNullable(PowerTrainType.getByName(view.getPowerTrainType()));
				if (powerTrainType.isEmpty()) view.displayError("Brak podanego typu napędu");
				else
					thing = Amphibious.builder().id(IdGenerator.getId()).name(view.getName()).surface(view.getSurface()).mass(view.getMass())
							.powerTrainType(powerTrainType.get()).build();
			}
			case BOAT -> {
				Optional<PowerTrainType> powerTrainType = Optional.ofNullable(PowerTrainType.getByName(view.getPowerTrainType()));
				if (powerTrainType.isEmpty()) view.displayError("Brak podanego typu napędu");
				else
					thing = Boat.builder().id(IdGenerator.getId()).name(view.getName()).surface(view.getSurface()).dipping(view.getDipping())
							.powerTrainType(powerTrainType.get()).build();
			}
			case CITY_CAR -> {
				Optional<PowerTrainType> powerTrainType = Optional.ofNullable(PowerTrainType.getByName(view.getPowerTrainType()));
				if (powerTrainType.isEmpty()) view.displayError("Brak podanego typu napędu");
				else
					thing = CityCar.builder().id(IdGenerator.getId()).name(view.getName()).surface(view.getSurface()).doorAmount(view.getDoorAmount())
							.powerTrainType(powerTrainType.get()).build();
			}
			case MOTORCYCLE -> {
				Optional<PowerTrainType> powerTrainType = Optional.ofNullable(PowerTrainType.getByName(view.getPowerTrainType()));
				if (powerTrainType.isEmpty()) view.displayError("Brak podanego typu napędu");
				else
					thing = Motorcycle.builder().id(IdGenerator.getId()).name(view.getName()).surface(view.getSurface()).maxSpeed(view.getMaxSpeed())
							.powerTrainType(powerTrainType.get()).build();
			}
			case OFF_ROAD_CAR -> {
				Optional<PowerTrainType> powerTrainType = Optional.ofNullable(PowerTrainType.getByName(view.getPowerTrainType()));
				if (powerTrainType.isEmpty()) view.displayError("Brak podanego typu napędu");
				else
					thing = OffRoadCar.builder().id(IdGenerator.getId()).name(view.getName()).surface(view.getSurface()).torque(view.getTorque())
							.powerTrainType(powerTrainType.get()).build();
			}
		}
		return thing;
	}

	private void performLogin() {
		while (currentUser == null) {
			try {
				currentUser = userService.findById(view.getUserId());
				view.displayLoginSuccess(currentUser.getName() + " " + currentUser.getSurname() + " [" + currentUser.getRole().getName() + "]");
			} catch (NoSuchUserException e) {
				view.displayError(e.getMessage());
			}
		}
	}
}
