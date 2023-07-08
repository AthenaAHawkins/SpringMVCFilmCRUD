package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {

	@Autowired
	private FilmDAO filmDao;

	@RequestMapping(path = { "/", "home.do" })
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "showFilm.do", params = "filmId")
	public ModelAndView showFilm(int filmId) {
		ModelAndView mv = new ModelAndView("WEB-INF/home.jsp");
		System.out.println("***** FilmId: " + filmId);

		Film film = filmDao.findFilmById(filmId);
		System.out.println("*** Film: " + film);

		mv.addObject("film", film);
		return mv;

	}

	@RequestMapping(path = "createFilm.do", params = "newFilm")
	public ModelAndView createFilm(Film newFilm) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("WEB-INF/createFilm.jsp");
		System.out.println("*** New Film: " + newFilm);
		Film createFilm = filmDao.createFilm(newFilm);
		System.out.println("*** Film: " + createFilm);
		mv.addObject("film", createFilm);
		mv.setViewName("WEB-INF/createFilm.jsp");
		return mv;
		


	}
	@RequestMapping(path = "deleteFilm.do", params = "deleteFilm")
	public ModelAndView deleteFilm(int filmId) {
		ModelAndView mv = new ModelAndView();
		System.out.println("*** DeletedFilm: " + filmId);
		boolean deleteFilm = filmDao.deleteFilm(filmId);
		System.out.println("*** DeletedFilm: " + deleteFilm);
		if(deleteFilm) {
			mv.setViewName("redirect:home.do");
		}
		else {
			mv.addObject("errorMessage", "Failed to delete film.");
		}
		return mv;
		
		
	}
	
	
	@RequestMapping(path = "getFilmByID.do") 
	public String getFilmByID() {
		
		return "WEB-INF/getFilmByID.jsp";
	}
	
// this is a comment 
}
