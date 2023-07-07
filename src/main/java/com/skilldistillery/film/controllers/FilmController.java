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
	
	
	@RequestMapping(path = {"/", "home.do"} )
	public ModelAndView goHome() {
		ModelAndView mv = new ModelAndView("WEB-INF/home.jsp");
		return mv;
	}
	
	@RequestMapping(path = "showFilm.do", params="filmId")
	public ModelAndView showFilm(int filmId) {
		ModelAndView mv = new ModelAndView("WEB-INF/home.jsp");
		System.out.println("***** FilmId: " + filmId);
		
		
		Film film = filmDao.findFilmById(filmId);
		System.out.println("*** Film: " + film);
		
		mv.addObject("film", film);
		return mv;
		
	}
}
