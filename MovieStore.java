public class MovieStore {

    private MovieLinkedList linkedList;
    private MovieBST bst;

    public MovieStore() {
        linkedList = new MovieLinkedList();
        bst = new MovieBST();
    }

    // Add a movie to both Linked List and BST. Rejects duplicate IDs so the
    // two structures stay in sync.
    public boolean addMovie(Movie movie) {
        if (bst.search(movie.getMovieId()) != null) {
            System.out.println("A movie with ID " + movie.getMovieId() + " already exists.");
            return false;
        }
        linkedList.addMovie(movie);
        bst.insert(movie);
        return true;
    }

    // Delete a movie from both Linked List and BST
    public void deleteMovie(int movieId) {
        Movie found = bst.search(movieId);
        if (found == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
            return;
        }
        linkedList.deleteMovie(movieId);
        bst.delete(movieId);
        System.out.println("Movie with ID " + movieId + " deleted successfully.");
    }

    // Search for a movie by ID using BST
    public void searchMovie(int movieId) {
        Movie found = bst.search(movieId);
        if (found == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
        } else {
            System.out.println("Movie found: " + found);
        }
    }

    // Rent a movie — moves one copy from stock into the rented pool so it can
    // be returned later. Differs from purchase, which removes stock permanently.
    public void rentMovie(int movieId) {
        Movie movie = bst.search(movieId);
        if (movie == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
            return;
        }
        if (movie.getStock() <= 0) {
            System.out.println("Sorry, \"" + movie.getTitle() + "\" is out of stock.");
            return;
        }
        movie.setStock(movie.getStock() - 1);
        movie.setRentedCount(movie.getRentedCount() + 1);
        System.out.println("You have rented \"" + movie.getTitle() + "\". Remaining stock: "
                + movie.getStock() + ". Currently rented: " + movie.getRentedCount());
    }

    // Return a rented copy — moves one copy from the rented pool back into stock.
    public void returnMovie(int movieId) {
        Movie movie = bst.search(movieId);
        if (movie == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
            return;
        }
        if (movie.getRentedCount() <= 0) {
            System.out.println("No copies of \"" + movie.getTitle() + "\" are currently rented.");
            return;
        }
        movie.setStock(movie.getStock() + 1);
        movie.setRentedCount(movie.getRentedCount() - 1);
        System.out.println("\"" + movie.getTitle() + "\" returned. New stock: "
                + movie.getStock() + ". Still rented: " + movie.getRentedCount());
    }

    // Purchase a movie — decrease stock by 1
    public void purchaseMovie(int movieId) {
        Movie movie = bst.search(movieId);
        if (movie == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
            return;
        }
        if (movie.getStock() <= 0) {
            System.out.println("Sorry, \"" + movie.getTitle() + "\" is out of stock.");
            return;
        }
        movie.setStock(movie.getStock() - 1);
        System.out.println("You have purchased \"" + movie.getTitle() + "\" for $" + movie.getPrice() + ". Remaining stock: " + movie.getStock());
    }

    // Restock a movie — increase stock by given amount
    public void restockMovie(int movieId, int amount) {
        Movie movie = bst.search(movieId);
        if (movie == null) {
            System.out.println("Movie with ID " + movieId + " not found.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Restock amount must be greater than zero.");
            return;
        }
        movie.setStock(movie.getStock() + amount);
        System.out.println("\"" + movie.getTitle() + "\" restocked. New stock: " + movie.getStock());
    }

    // Display all movies using Linked List traversal
    public void displayAllMovies() {
        System.out.println("\n--- All Movies in Store ---");
        linkedList.displayAll();
    }
}
