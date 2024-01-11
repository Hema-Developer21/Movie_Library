package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import dto.Admin;
import dto.Movie;

public class Dao1 
{
	public Connection getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/movielibrary","root","root");
		
	}
	public int SaveAdmin(Admin admin) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into admin values(?,?,?,?,?)");
		
		pst.setInt(1, admin.getAdminId());
		pst.setString(2, admin.getAdminName());
		pst.setLong(3, admin.getAdminContact());
		pst.setString(4, admin.getAdminEmail());
		pst.setString(5, admin.getAdminPassword());
		return pst.executeUpdate();
		
	}
	public Admin findByEmail(String adminmail) throws ClassNotFoundException, SQLException 
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select*from admin where AdminEmail=?");
		pst.setString(1, adminmail);
		ResultSet rs=pst.executeQuery();
		rs.next();
		Admin a=new Admin();
		a.setAdminId(rs.getInt(1));
		a.setAdminName(rs.getString(2));
		a.setAdminContact(rs.getLong(3));
		a.setAdminEmail(rs.getString(4));
		a.setAdminPassword(rs.getString(5));
		return a;
		
		
	}
	public int SaveMovie(Movie movie) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("insert into movie values(?,?,?,?,?,?,?)");
		pst.setInt(1, movie.getMovieId());
		pst.setString(2, movie.getMovieName());
		pst.setDouble(3, movie.getMoviePrice());
		pst.setDouble(4, movie.getMovieRating());
		pst.setString(5, movie.getMovieGenre());
		pst.setString(6, movie.getMovieLanguage());
		Blob imageBlob=new SerialBlob(movie.getMovieImage());
		pst.setBlob(7, imageBlob);
		return pst.executeUpdate();
		
	}
	public List<Movie> getAllMovies() throws ClassNotFoundException, SQLException 
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("Select*from movie");
		ResultSet rs=pst.executeQuery();
		List<Movie> movies=new ArrayList<Movie>();
		while(rs.next())
		{
			Movie m=new Movie();
			m.setMovieId(rs.getInt(1));
			m.setMovieName(rs.getString(2));
			m.setMoviePrice(rs.getDouble(3));
			m.setMovieRating(rs.getDouble(4));
			m.setMovieGenre(rs.getString(5));
			m.setMovieLanguage(rs.getString(6));
			Blob b=rs.getBlob(7);
			byte[] img=b.getBytes(1, (int)b.length());
			m.setMovieImage(img);
			movies.add(m);
		}
		return movies;
	}
	public int deleteMovie(int id) throws ClassNotFoundException, SQLException 
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("delete from movie where MovieId=?" );
		pst.setInt(1, id);
		int res=pst.executeUpdate();
		return res ;
		
	}
	public Movie findMovieById(int id) throws ClassNotFoundException, SQLException 
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("select*from movie where MovieId=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		rs.next();
		Movie m= new Movie();
		m.setMovieId(rs.getInt(1));
		m.setMovieName(rs.getString(2));
		m.setMoviePrice(rs.getDouble(3));
		m.setMovieRating(rs.getDouble(4));
		m.setMovieGenre(rs.getString(5));
		m.setMovieLanguage(rs.getString(6));
		Blob b=rs.getBlob(7);
		byte[] img=b.getBytes(1, (int)b.length());
		m.setMovieImage(img);
		
		return m;
		
	}
	public int UpdateMovie(Movie movie) throws ClassNotFoundException, SQLException
	{
		Connection conn=getConnection();
		PreparedStatement pst=conn.prepareStatement("update movie set MovieName=?,MoviePrice=?,MovieRating=?,MovieGenre=?,MovieLanguage=?,MovieImage=? where MovieId=?");
		pst.setInt(7, movie.getMovieId());
		pst.setString(1, movie.getMovieName());
		pst.setDouble(2, movie.getMoviePrice());
		pst.setDouble(3, movie.getMovieRating());
		pst.setString(4, movie.getMovieGenre());
		pst.setString(5, movie.getMovieLanguage());
		Blob imageBlob=new SerialBlob(movie.getMovieImage());
		pst.setBlob(6, imageBlob);
		return pst.executeUpdate();
		
	}
	
}
