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

	@RequestMapping(path = "showFilm.do", params = "filmId")
	public ModelAndView showFilm(int filmId) {
		ModelAndView mv = new ModelAndView("WEB-INF/getFilmByID.jsp");

		System.out.println("***** FilmId: " + filmId);
		Film film = filmDao.findFilmById(filmId);
		System.out.println("*** Film: " + film);

		mv.addObject("film", film);
		return mv;

	}

	@RequestMapping(path = "createFilm.do")
	public ModelAndView createFilm(@RequestParam("title") String title,@RequestParam("description") String description) {
		ModelAndView mv = new ModelAndView("WEB-INF/createFilm.jsp");
		//System.out.println("*** New Film: " + newFilm);
		Film createFilm = filmDao.createFilm(new Film(title,description));
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
		if(deleteFilm) {
			mv.setViewName("redirect:home.do");
		}
		else {
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
		return "WEB-INF/saveFilm.jsp";
	}
	
	@RequestMapping(path = "saveFilm.do")
	public ModelAndView updateFilm(@RequestParam("filmInfo")Film savedFilm) {
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
	public ModelAndView searchFilms(@RequestParam("keyword")String keyword) {
		ModelAndView mv = new ModelAndView("WEB-INF/getFilmByID.jsp");
		List<Film>films = filmDao.findByKeyword(keyword);
		mv.addObject("films", films);
		return mv;
	}
	
	
// this is a comment 
}
