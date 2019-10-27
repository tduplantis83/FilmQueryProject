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
		app.launch();
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
			System.out.println("*****Welcome to Database Gangsta's Movie Menu*****");
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
					showfilmDetails(film, input);
				}
				break;
			case '2':
				System.out.print("Enter a word or phrase to find a film by Title &/or Description: ");
				input.nextLine();
				filmList = db.findFilmsByKeyword(input.nextLine());
				if (filmList.size() < 1) {
					System.out.println("No films found matching that keyword");
				} else {
					for (Film film2 : filmList) {
						System.out.println(film2);
					}
					showfilmDetails(filmList, input);
				}
				break;
			case '3':
				System.out.println("Goodbye!");
				break;
			default:
				System.err.println("\nERROR - Invalid Input. Try again.\n");
			}
		} while (choice != '3');

	}

	private void showfilmDetails(List<Film> filmList, Scanner input) {
		char choice = '1';

		do {
			System.out.println("1. Show ALL film details");
			System.out.println("2. Return to main menu");
			choice = input.next().charAt(0);

			switch (choice) {
			case '1':
				for (Film film : filmList) {
					System.out.println(film.allDetails());
				}
				return;
			case '2':
				System.out.println("Returning to main menu....\n");
				break;
			default:
				System.err.println("\nERROR - Invalid Input. Try again...\n");
				break;
			}
		} while (choice != '2');
	}

	private void showfilmDetails(Film film, Scanner input) {
		char choice = '1';

		do {
			System.out.println("1. Show ALL film details");
			System.out.println("2. Return to main menu");
			choice = input.next().charAt(0);

			switch (choice) {
			case '1':
				System.out.println(film.allDetails());
				return;
			case '2':
				System.out.println("Returning to main menu....\n");
				break;
			default:
				System.err.println("\nERROR - Invalid Input. Try again...\n");
				break;
			}
		} while (choice != '2');
	}

}
