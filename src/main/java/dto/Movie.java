package dto;

import java.util.Arrays;

public class Movie 
{
	private int MovieId;
	private String MovieName;
	private double MoviePrice;
	private double MovieRating;
	private String MovieGenre;
	private String MovieLanguage;
	private byte[] MovieImage;
	
	
	public int getMovieId() 
	{
		return MovieId;
	}
	public void setMovieId(int movieId) 
	{
		this.MovieId = movieId;
	}
	public String getMovieName() 
	{
		return MovieName;
	}
	public void setMovieName(String movieName) 
	{
		this.MovieName = movieName;
	}
	public double getMoviePrice() 
	{
		return MoviePrice;
	}
	public void setMoviePrice(double moviePrice) 
	{
		this.MoviePrice = moviePrice;
	}
	public double getMovieRating() {
		return MovieRating;
	}
	public void setMovieRating(double movieRating) 
	{
		this.MovieRating = movieRating;
	}
	public String getMovieGenre() 
	{
		return MovieGenre;
	}
	public void setMovieGenre(String movieGenre) 
	{
		this.MovieGenre = movieGenre;
	}
	public String getMovieLanguage() 
	{
		return MovieLanguage;
	}
	public void setMovieLanguage(String movieLanguage) 
	{
		this.MovieLanguage = movieLanguage;
	}
	public byte[] getMovieImage() 
	{
		return MovieImage;
	}
	public void setMovieImage(byte[] movieImage) 
	{
		this.MovieImage = movieImage;
	}
	@Override
	public String toString() {
		return "Movie [MovieId=" + MovieId + ", MovieName=" + MovieName + ", MoviePrice=" + MoviePrice
				+ ", MovieRating=" + MovieRating + ", MovieGenre=" + MovieGenre + ", MovieLanguage=" + MovieLanguage
				+ ", MovieImage=" + Arrays.toString(MovieImage) + "]";
	}
	
	
	
	

}
