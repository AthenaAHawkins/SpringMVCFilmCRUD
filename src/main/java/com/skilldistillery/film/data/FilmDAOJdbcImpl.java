package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

public class FilmDAOJdbcImpl implements FilmDAO{
	String user = "student";
	String pass = "student";
	String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Film findFilmById(int filmId) {
		Film film = null;
		String sql = "SELECT title, release_year, rating, description FROM film WHERE id = ?";

		try {
			Connection conn;
			conn = DriverManager.getConnection(URL, user, pass);
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, filmId);
		ResultSet filmResult = pstmt.executeQuery();

		if (filmResult.next()) {
			film = new Film();
			film.setId(filmId);
			film.setTitle(filmResult.getString("title"));
			film.setReleaseYear(filmResult.getInt("release_year"));
			film.setRating(filmResult.getString("rating"));
			film.setDescription(filmResult.getString("description"));
			film.setActors(findActorsByFilmId(filmId));
			System.out.println();

		}
		filmResult.close();
		pstmt.close();
		conn.close();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return film;
	}


	@Override
	public List<Actor> findActorsByFilmId(int filmId) {
		List<Actor> actors = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT actor.*" + " FROM film JOIN film_actor ON film.id = film_actor.film_id "
					+ " JOIN actor ON film_actor.actor_id = actor.id " + " WHERE film_id = ?";
			PreparedStatement prepstmt = conn.prepareStatement(sql);
			prepstmt.setInt(1, filmId);
			ResultSet actorsresult = prepstmt.executeQuery();

			while (actorsresult.next()) {
				int actorId = actorsresult.getInt("id");
				String actsFirstNm = actorsresult.getString("first_name");
				String actsLastNm = actorsresult.getString("last_name");
				Actor actor = new Actor(actorId, actsFirstNm, actsLastNm);
				actors.add(actor);
			}
			actorsresult.close();
			prepstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return actors;
	}

	@Override
	public List<Film> findByKeyWord(String keyWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film createFilm(Film newFilm) {
		Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    
		    String sql = "INSERT INTO film (title, description, language_id) "
		                     + " VALUES (?,?,?)";
		    
		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    stmt.setString(1, newFilm.getTitle());
		    stmt.setString(2, newFilm.getDescription());
		    stmt.setInt(3, 1);
		    int updateCount = stmt.executeUpdate();
		    
		    if (updateCount == 1) {
		      ResultSet keys = stmt.getGeneratedKeys();
		      
		      if (keys.next()) {
		        int newFilmID = keys.getInt(1);
		        newFilm.setId(newFilmID);
		        if (newFilm.getActors() != null && newFilm.getActors().size() > 0) {
		          sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
		          stmt = conn.prepareStatement(sql);
		          for (Actor actor : newFilm.getActors()) {
		            stmt.setInt(1, newFilmID);
		            stmt.setInt(2, actor.getId());
		            updateCount = stmt.executeUpdate();
		          }
		        }
		      }
		    } else {
		      newFilm = null;
		    }
		    conn.commit(); // COMMIT TRANSACTION
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    throw new RuntimeException("Error inserting actor " + newFilm);
		  }
		  return newFilm;
	}

	@Override
	public boolean deleteFilm(int filmId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Film updateFilm(Film updatedFilm) {
		// TODO Auto-generated method stub
		return null;
	}


}
