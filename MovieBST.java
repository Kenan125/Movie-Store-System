public class MovieBST {

	BSTNode root;

	public MovieBST() {
		this.root = null;
	}

	public void insert(Movie movie) {
		root = insertRecursive(root, movie);
	}

	private BSTNode insertRecursive(BSTNode current, Movie movie) {
		if (current == null) {
			return new BSTNode(movie);
		}

		int newId = movie.getMovieId();
		int currentId = current.movie.getMovieId();

		if (newId < currentId) {
			current.left = insertRecursive(current.left, movie);
		} else if (newId > currentId) {
			current.right = insertRecursive(current.right, movie);
		}
		// duplicate IDs are silently ignored — BST keys must be unique

		return current;
	}
}
