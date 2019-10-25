package com.skilldistillery.filmquery.database;

import java.sql.*;
import java.util.*;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public class DatabaseAccessorObject implements DatabaseAccessor {

	// string to connect to the database
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false";

	static {
		try {
			// finds the driver to use to connect to mysql
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film filmResult = null;
		Actor actorResult = null;
		List<Actor> cast = new ArrayList<>();
		String username = "student";
		String password = "student";

		// automatically closes connections
		try (Connection conn = DriverManager.getConnection(URL, username, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT film.* from film where film.id = ?");) {
			stmt.setInt(1, filmId);

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					filmResult = new Film();
					filmResult.setId(rs.getInt("id"));
					filmResult.setTitle(rs.getString("title"));
					filmResult.setDescription(rs.getString("description"));
					filmResult.setReleaseYear(rs.getInt("release_year"));
					filmResult.setLanguageId(rs.getInt("language_id"));
					filmResult.setRentalDuration(rs.getInt("rental_duration"));
					filmResult.setRentalRate(rs.getDouble("rental_rate"));
					filmResult.setLength(rs.getInt("length"));
					filmResult.setReplacementCost(rs.getDouble("replacement_cost"));
					filmResult.setRating(rs.getString("rating"));
					filmResult.setSpecialFeatures(rs.getString("special_features"));
				}
			}
		}

		catch (SQLException e) {
			System.err.println(e);
		}

		// automatically closes connections
		try (Connection conn = DriverManager.getConnection(URL, username, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT actor.* from actor inner join film_actor fa on fa.actor_id = actor.id inner join film on film.id = fa.film_id where film.id = ?");) {
			stmt.setInt(1, filmId);

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					actorResult = new Actor();

					actorResult.setId(rs.getInt("id"));
					actorResult.setFirstName(rs.getString("first_name"));
					actorResult.setLastName(rs.getString("last_name"));
					
					cast.add(actorResult);
				}
			}
		}

		catch (SQLException e) {
			System.err.println(e);
		}
		
		filmResult.setCast(cast);

		return filmResult;
	}

	@Override
	public Actor findActorById(int actorId) {
		Actor actorResult = null;
		String username = "student";
		String password = "student";

		// automatically closes connections
		try (Connection conn = DriverManager.getConnection(URL, username, password);
				PreparedStatement stmt = conn.prepareStatement("SELECT actor.* FROM actor where actor.id = ?");) {
			stmt.setInt(1, actorId);

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					actorResult = new Actor();

					actorResult.setId(rs.getInt("id"));
					actorResult.setFirstName(rs.getString("first_name"));
					actorResult.setLastName(rs.getString("last_name"));
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		return actorResult;
	}

	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		Actor actorResult = null;
		List<Actor> actorsByFilmId = new ArrayList<>();
		String username = "student";
		String password = "student";

		// automatically closes connections
		try (Connection conn = DriverManager.getConnection(URL, username, password);
				PreparedStatement stmt = conn.prepareStatement(
						"SELECT actor.* FROM actor inner join film_actor fa on fa.actor_id = actor.id inner join film on film.id = fa.film_id where film.id = ?");) {
			stmt.setInt(1, filmId);

			try (ResultSet rs = stmt.executeQuery();) {

				while (rs.next()) {
					actorResult = new Actor();
					actorResult.setId(rs.getInt("id"));
					actorResult.setFirstName(rs.getString("first_name"));
					actorResult.setLastName(rs.getString("last_name"));

					actorsByFilmId.add(actorResult);
				}
			}
		} catch (SQLException e) {
			System.err.println(e);
		}

		if (actorResult.getId() == 0) {
			return null;
		}

		return actorsByFilmId;
	}

}
