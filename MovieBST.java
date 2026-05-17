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

	public Movie search(int movieId) {
		return searchRecursive(root, movieId);
	}

	private Movie searchRecursive(BSTNode current, int movieId) {
		if (current == null) {
			return null;
		}
		int currentId = current.movie.getMovieId();
		if (movieId == currentId) {
			return current.movie;
		}
		if (movieId < currentId) {
			return searchRecursive(current.left, movieId);
		}
		return searchRecursive(current.right, movieId);
	}

	public void delete(int movieId) {
		root = deleteRecursive(root, movieId);
	}

	private BSTNode deleteRecursive(BSTNode current, int movieId) {
		if (current == null) {
			return null;
		}
		int currentId = current.movie.getMovieId();
		if (movieId < currentId) {
			current.left = deleteRecursive(current.left, movieId);
		} else if (movieId > currentId) {
			current.right = deleteRecursive(current.right, movieId);
		} else {
			if (current.left == null) {
				return current.right;
			}
			if (current.right == null) {
				return current.left;
			}
			BSTNode successor = findMin(current.right);
			current.movie = successor.movie;
			current.right = deleteRecursive(current.right, successor.movie.getMovieId());
		}
		return current;
	}

	private BSTNode findMin(BSTNode node) {
		while (node.left != null) {
			node = node.left;
		}
		return node;
	}

	public void inorderTraversal() {
		if (root == null) {
			System.out.println("No movies in the tree.");
			return;
		}
		inorderRecursive(root);
	}

	private void inorderRecursive(BSTNode current) {
		if (current == null) {
			return;
		}
		inorderRecursive(current.left);
		System.out.println(current.movie);
		inorderRecursive(current.right);
	}
}
