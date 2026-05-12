


public class Movie {

	private int movieId;
	private String title;
	private String genre;
	private double price;
	private int stock;

	public Movie(int movieId, String title, String genre, double price, int stock) {
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.stock = stock;
	}

	
	int getMovieId() {
		return movieId;
	}

	String getTitle() {
		return title;
	}

	String getGenre() {
		return genre;
	}

	double getPrice() {
		return price;
	}

	int getStock() {
		return stock;
	}

	
	
	void setTitle(String title) {
		this.title = title;
	}

	void setGenre(String genre) {
		this.genre = genre;
	}

	void setPrice(double price) {
		this.price = price;
	}

	void setStock(int stock) {
		this.stock = stock;
	}

	
	public String toString() {
		return "ID: " + movieId + " | Title: " + title + " | Genre: " + genre + " | Price: $" + price + " | Stock: "
				+ stock;
	}
}
