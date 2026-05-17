import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MovieStore store = new MovieStore();
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Add some sample movies to start with
        store.addMovie(new Movie(1, "Inception", "Sci-Fi", 12.99, 5));
        store.addMovie(new Movie(2, "The Dark Knight", "Action", 9.99, 3));
        store.addMovie(new Movie(3, "Interstellar", "Sci-Fi", 11.99, 4));

        System.out.println("========================================");
        System.out.println("       Welcome to the Movie Store!      ");
        System.out.println("========================================");

        while (choice != 0) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Display all movies");
            System.out.println("2. Add a movie");
            System.out.println("3. Delete a movie");
            System.out.println("4. Search movie by ID");
            System.out.println("5. Rent a movie");
            System.out.println("6. Purchase a movie");
            System.out.println("7. Restock a movie");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:
                    store.displayAllMovies();
                    break;

                case 2:
                    System.out.print("Enter Movie ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter Stock: ");
                    int stock = scanner.nextInt();
                    store.addMovie(new Movie(id, title, genre, price, stock));
                    System.out.println("Movie added successfully!");
                    break;

                case 3:
                    System.out.print("Enter Movie ID to delete: ");
                    int deleteId = scanner.nextInt();
                    store.deleteMovie(deleteId);
                    break;

                case 4:
                    System.out.print("Enter Movie ID to search: ");
                    int searchId = scanner.nextInt();
                    store.searchMovie(searchId);
                    break;

                case 5:
                    System.out.print("Enter Movie ID to rent: ");
                    int rentId = scanner.nextInt();
                    store.rentMovie(rentId);
                    break;

                case 6:
                    System.out.print("Enter Movie ID to purchase: ");
                    int purchaseId = scanner.nextInt();
                    store.purchaseMovie(purchaseId);
                    break;

                case 7:
                    System.out.print("Enter Movie ID to restock: ");
                    int restockId = scanner.nextInt();
                    System.out.print("Enter amount to add to stock: ");
                    int amount = scanner.nextInt();
                    store.restockMovie(restockId, amount);
                    break;

                case 0:
                    System.out.println("Thank you for visiting the Movie Store. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
