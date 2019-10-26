package com.skilldistillery.filmquery.app;

import java.util.*;

import com.skilldistillery.filmquery.database.DatabaseAccessor;
import com.skilldistillery.filmquery.database.DatabaseAccessorObject;
import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class FilmQueryApp {

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

	private void test() {
		Film film = db.findFilmById(1);
		Actor actor = db.findActorById(1);

		System.out.println(film);
		System.out.println(actor);

	}

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {
		char choice;
		Film film = null;
		List<Film> filmList = new ArrayList<>();
		do {
			System.out.println("************Movie Menu************");
			System.out.println("1. Look up film by ID");
			System.out.println("2. Search for a film");
			System.out.println("3. Exit");
			choice = input.next().charAt(0);

			switch (choice) {
			case '1':
				System.out.print("Enter a film ID to search for: ");
				film = db.findFilmById(input.nextInt());
				if (film == null) {
					System.out.println("No films found matching that Film ID");
				} else {
					System.out.println(film + "\n");
				}
				break;
			case '2':
				System.out.print("Enter a keyword to search film Title and Description: ");
				filmList = db.findFilmsByKeyword(input.next());
				if (filmList.size() < 1) {
					System.out.println("No films found matching that keyword");
				} else {
					for (Film film2 : filmList) {
						System.out.println(film2);
					}
				}
				break;
			}
		} while (choice != '3');

	}

	private void userSelection(char choice, Scanner input) {

	}

}
