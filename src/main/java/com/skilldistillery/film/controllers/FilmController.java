package com.skilldistillery.film.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(path = "createFilm.do", params = "newFilm")
	public ModelAndView createFilm(Film newFilm) {
		ModelAndView mv = new ModelAndView("WEB-INF/getCreateFilm.jsp");
		System.out.println("*** New Film: " + newFilm);
		Film createFilm = filmDao.createFilm(newFilm);
		System.out.println("*** Film: " + createFilm);
		mv.addObject("film", createFilm);
		
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
	@RequestMapping(path = "getCreateFilm.do")
	public String getCreateFilm() {
		
		return "WEB-INF/getCreateFilm.jsp";
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
	@RequestMapping(path = "searchFilms.do", params = "keyword")
	public ModelAndView searchFilms(String keyword) {
		ModelAndView mv = new ModelAndView("WEB-INF/searchResults.jsp");
		List<Film>films = filmDao.findByKeyword(keyword);
		mv.addObject("films", films);
		return mv;
	}
	
	
// this is a comment 
}
