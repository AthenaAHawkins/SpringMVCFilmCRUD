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
		ModelAndView mv = new ModelAndView("WEB-INF/home.jsp");
		return mv;
	}

	@RequestMapping(path = "showFilm.do", params = "filmId")
	public ModelAndView showFilm(int filmId) {
<<<<<<< HEAD
		ModelAndView mv = new ModelAndView("WEB-INF/showFilm.jsp");
=======
		ModelAndView mv = new ModelAndView("WEB-INF/getFilmByID.jsp");
>>>>>>> ce0309a5fdbda6f2228f1cbad1af0131fd936fa0
		System.out.println("***** FilmId: " + filmId);

		Film film = filmDao.findFilmById(filmId);
		System.out.println("*** Film: " + film);

		mv.addObject("film", film);
		return mv;

	}

	@RequestMapping(path = "createFilm.do", params = "newFilm")
	public ModelAndView createFilm(Film newFilm) {
		ModelAndView mv = new ModelAndView();
		System.out.println("*** New Film: " + newFilm);
		Film createFilm = filmDao.createFilm(newFilm);
		System.out.println("*** Film: " + createFilm);
		mv.addObject("film", createFilm);
		mv.setViewName("WEB-INF/showFilm.jsp");
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
	@RequestMapping(path = "saveFilm.do")
	public ModelAndView updateFilm(Film savedFilm) {
		ModelAndView mv = new ModelAndView();
		boolean film = filmDao.saveFilm(savedFilm);
		System.out.println("**** SaveFilm" + film);
		if(film) {
			mv.setViewName("redirect:home.do");
		}
		else {
			mv.addObject("errorMessage", "Failed to delete film.");
		}
		return mv;
		
	}
	
	


	
// this is a comment 
}
