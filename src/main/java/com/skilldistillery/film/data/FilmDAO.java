package com.skilldistillery.film.data;

import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public interface FilmDAO {
	public Film findFilmById(int filmId) ;
	public List<Actor> findActorsByFilmId(int filmId);
	public List<Film> findByKeyWord(String keyWord);
	public Film createFilm(Film newFilm);
	public boolean deleteFilm(int filmId);
	boolean saveFilm(Film updatedFilm);
}
