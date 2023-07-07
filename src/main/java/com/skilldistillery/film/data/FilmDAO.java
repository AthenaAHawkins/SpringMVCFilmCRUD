package com.skilldistillery.film.data;

import java.sql.SQLException;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId) throws SQLException;
	public Actor findActorById(int actorId) throws SQLException;
	public List<Film> findFilmsByActorId(int actorId);
	public List<Actor> findActorsByFilmId(int filmId);
	public List<Film> findByKeyWord(String keyWord);
	public Actor createActor(Actor actor);
	public boolean saveActor(Actor actor);
	public boolean deleteActor(Actor actor);
	public Film createFilm(Film newFilm);
	public boolean deleteFilm(int filmId);
}
