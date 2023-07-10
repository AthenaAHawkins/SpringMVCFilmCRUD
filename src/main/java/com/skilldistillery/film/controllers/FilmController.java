package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView("WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "showFilm.do")
	public ModelAndView showFilm(int filmId) {
		ModelAndView mv = new ModelAndView("WEB-INF/getFilmByID.jsp");

		System.out.println("***** FilmId: " + filmId);
		Film film = filmDao.findFilmById(filmId);
		System.out.println("*** Film: " + film);

		mv.addObject("film", film);
		return mv;

	}

	@RequestMapping(path = "createFilm.do")
	public ModelAndView createFilm(@RequestParam("title") String title, @RequestParam("description") String description,
			@RequestParam("releaseYear") int releaseYear) {
		ModelAndView mv = new ModelAndView("WEB-INF/createFilm.jsp");
		// System.out.println("*** New Film: " + newFilm);
		Film createFilm = filmDao.createFilm(new Film(title, description, releaseYear));
		System.out.println("*** Film: " + createFilm);
		mv.addObject("film", createFilm);
		mv.setViewName("WEB-INF/home.jsp");
		return mv;

	}

	@RequestMapping(path = "deleteFilm.do")
	public ModelAndView deleteFilm(@RequestParam("filmId") int filmId) {
		ModelAndView mv = new ModelAndView();
		System.out.println("*** DeletedFilm: " + filmId);
		boolean deleteFilm = filmDao.deleteFilm(filmId);

		System.out.println("*** DeletedFilm: " + deleteFilm);
		if (deleteFilm) {
			mv.setViewName("redirect:home.do");
		} else {
			mv.addObject("errorMessage", "Failed to delete film.");
		}
		return mv;

	}

	@RequestMapping(path = "getCreateFilm.do")
	public String getCreateFilmByID() {

		return "WEB-INF/createFilm.jsp";

	}

	@RequestMapping(path = "getFilmByID.do")
	public String getFilmByID() {

		return "WEB-INF/getFilmByID.jsp";
	}

	@RequestMapping(path = "updateFilmInfo.do")
	public String updateFilmInfo() {
		return "WEB-INF/update.jsp";
	}

	

	@RequestMapping(path = "saveFilm.do")
	public ModelAndView updateFilm(@RequestParam("title") String title, String description, int releaseYear, @RequestParam("id") int Id) {
		Film film = new Film(title, description, releaseYear);
		film.setId(Id);
		boolean updated = filmDao.saveFilm(film);
		film = filmDao.findFilmById(Id);
		ModelAndView mv = new ModelAndView();
		// System.out.println("**** SaveFilm" + film);

		mv.setViewName("WEB-INF/getFilmByID.jsp");
		mv.addObject("film", film);
		return mv;

	}

	@RequestMapping(path = "searchFilms.do", params = "keyword")

	public ModelAndView searchFilms(@RequestParam("keyword") String keyword) {
		ModelAndView mv = new ModelAndView("WEB-INF/getFilmByID.jsp");
		List<Film> films = filmDao.findByKeyword(keyword);

		mv.addObject("films", films);
		return mv;
	}

}
