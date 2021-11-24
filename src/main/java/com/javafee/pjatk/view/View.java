package com.javafee.pjatk.view;

import java.time.LocalDate;
import java.util.Scanner;

public class View {
	private Scanner scanner = new Scanner(System.in);

	/* get */

	public int getUserId() {
		System.out.print("Zaloguj się\nId uzytkownika: ");
		return scanner.nextInt();
	}

	public int getPersonId() {
		System.out.print("Id osoby: ");
		return scanner.nextInt();
	}

	public int getFlatId() {
		System.out.print("Id mieszkania: ");
		return scanner.nextInt();
	}

	public String getThingType() {
		System.out.println("Podaj typ przedmiotu który chcesz dodać:\n" +
				"[item, amphibious, boat, city-car, motorcycle, offroad-car]");
		return scanner.next();
	}

	public String getPowerTrainType() {
		System.out.println("Podaj typ napędu:\n" +
				"[gasoline, diesel, hybrid, electric, oxygen, gas]");
		return scanner.next();
	}

	public String getName() {
		System.out.println("Podaj nazwę:");
		return scanner.next();
	}

	public Double getSurface() {
		System.out.println("Podaj powierzchnię:");
		return scanner.nextDouble();
	}

	public Double getMass() {
		System.out.println("Podaj masę:");
		return scanner.nextDouble();
	}

	public Double getDipping() {
		System.out.println("Podaj zanużenie:");
		return scanner.nextDouble();
	}

	public int getDoorAmount() {
		System.out.println("Ilość drzwi:");
		return scanner.nextInt();
	}

	public int getMaxSpeed() {
		System.out.println("Maksymalna prędkość:");
		return scanner.nextInt();
	}

	public int getTorque() {
		System.out.println("Moment obrotowy:");
		return scanner.nextInt();
	}

	public int getParkingId() {
		System.out.print("Id parkingu: ");
		return scanner.nextInt();
	}

	public int getThingId() {
		System.out.print("Id przedmiotu: ");
		return scanner.nextInt();
	}

	/* display */

	public void displayLoginSuccess(String user) {
		System.out.println("Zalogowany jako: " + user);
	}

	public void displayRentSuccess(int rentId, LocalDate endDate) {
		System.out.printf("Umowa najmu o numerze %d została zawarta, obowiązuje do %s\n", rentId, endDate.toString());
	}

	public void displayUserData(String userData) {
		System.out.println("User data:\n" + userData);
	}

	public void displayError(String message) {
		System.err.println("Nastąpił błąd: " + message);
	}

	/* menu */

	public int displayLandlordMenu() {
		System.out.println("Wybierz co chcesz zrobić:\n" +
				"- [1] - zapisz dane osiedla do pliku");
		return scanner.nextInt();
	}

	public int displayTenantsMenu() {
		System.out.println("Wybierz co chcesz zrobić:\n" +
				"- [1] - wyświetl wolne pomieszczenia\n" +
				"- [2] - wynajmij pomieszczenie\n" +
				"- [3] - wyświetl moje dane łącznie z wynajętymi pomieszczeniami\n" +
				"- [4] - dodaj współlokatora\n" +
				"- [5] - dodaj przedmiot/samochód do garażu\n" +
				"- [6] - usuń przedmiot/samochód do garażu");
		return scanner.nextInt();
	}
}
