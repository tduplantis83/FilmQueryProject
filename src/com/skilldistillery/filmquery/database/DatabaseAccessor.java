package com.skilldistillery.filmquery.database;

import java.util.*;

import com.skilldistillery.filmquery.entities.Actor;
import com.skilldistillery.filmquery.entities.Film;

public interface DatabaseAccessor {
  public Film findFilmById(int filmId);
  public Actor findActorById(int actorId);
  public List<Actor> findActorsByFilmId(int filmId);
  public List<Film> findFilmsbyActorId(int actorID);
  public List<Film> findFilmsByKeyword(String keyword);
  public Map<String, Integer>  findInventoryConditionCountByFilmId(int filmId);
}
