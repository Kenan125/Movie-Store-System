public class MovieLinkedList {
	private Node head;

	public MovieLinkedList() {
		head = null;
	}

	public void addMovie(Movie movie) {
		Node newNode = new Node(movie);
		if (head == null) {
			head = newNode;
		} else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
	}

	public void deleteMovie(int movieId) {
		if (head == null) {
			System.out.println("List is empty.");
			return;
		}
		if (head.movie.getMovieId() == movieId) {
			head = head.next;
			System.out.println("Movie deleted.");
			return;
		}
		Node current = head;
		while (current.next != null) {
			if (current.next.movie.getMovieId() == movieId) {
				current.next = current.next.next;
				System.out.println("Movie deleted.");
				return;
			}
			current = current.next;
		}
		System.out.println("Movie not found.");
	}

	public Movie searchMovie(int movieId) {
		Node current = head;
		while (current != null) {
			if (current.movie.getMovieId() == movieId) {
				return current.movie;
			}
			current = current.next;
		}
		return null;
	}

	public void displayAll() {
		if (head == null) {
			System.out.println("No movies in the list.");
			return;
		}
		Node current = head;
		while (current != null) {
			System.out.println(current.movie);
			current = current.next;
		}
	}
}