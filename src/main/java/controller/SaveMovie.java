package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.Dao1;
import dto.Movie;

@WebServlet("/SaveMovie1")
@MultipartConfig(maxFileSize=5*1024*1024)
public class SaveMovie extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		int MovieId=Integer.parseInt(req.getParameter("MovieId"));
		String MovieName=req.getParameter("MovieName");
		Double MoviePrice=Double.parseDouble(req.getParameter("MoviePrice"));
		Double MovieRating=Double.parseDouble(req.getParameter("MovieRating"));
		String MovieGenre=req.getParameter("MovieGenre");
		String MovieLanguage=req.getParameter("MovieLanguage");
		Part imagepart=req.getPart("MovieImage");
		Movie movie=new Movie();
		movie.setMovieId(MovieId);
		movie.setMovieName(MovieName);
		movie.setMoviePrice(MoviePrice);
		movie.setMovieRating(MovieRating);
		movie.setMovieGenre(MovieGenre);
		movie.setMovieLanguage(MovieLanguage);
		movie.setMovieImage(imagepart.getInputStream().readAllBytes());
		
		Dao1 dao1=new Dao1();
		try {
			dao1.SaveMovie(movie);
			req.setAttribute("Movies", dao1.getAllMovies());
			
			RequestDispatcher dis=req.getRequestDispatcher("Home.jsp");
			dis.include(req, resp);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
