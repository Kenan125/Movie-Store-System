import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        MovieStore store = new MovieStore();
        Scanner scanner = new Scanner(System.in);

        // Sample movies
        store.addMovie(new Movie(1, "Inception", "Sci-Fi", 12.99, 5));
        store.addMovie(new Movie(2, "The Dark Knight", "Action", 9.99, 3));
        store.addMovie(new Movie(3, "Interstellar", "Sci-Fi", 11.99, 4));

        System.out.println("========================================");
        System.out.println("       Welcome to the Movie Store!      ");
        System.out.println("========================================");

        int choice = -1;
        while (choice != 0) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Display all movies");
            System.out.println("2. Add a movie");
            System.out.println("3. Delete a movie");
            System.out.println("4. Search movie by ID");
            System.out.println("5. Rent a movie");
            System.out.println("6. Purchase a movie");
            System.out.println("7. Restock a movie");
            System.out.println("8. Return a rented movie");
            System.out.println("0. Exit");
            choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    store.displayAllMovies();
                    break;

                case 2: {
                    int id = readInt(scanner, "Enter Movie ID: ");
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = scanner.nextLine();
                    double price = readNonNegativeDouble(scanner, "Enter Price: ");
                    int stock = readNonNegativeInt(scanner, "Enter Stock: ");
                    if (store.addMovie(new Movie(id, title, genre, price, stock))) {
                        System.out.println("Movie added successfully!");
                    }
                    break;
                }

                case 3:
                    store.deleteMovie(readInt(scanner, "Enter Movie ID to delete: "));
                    break;

                case 4:
                    store.searchMovie(readInt(scanner, "Enter Movie ID to search: "));
                    break;

                case 5:
                    store.rentMovie(readInt(scanner, "Enter Movie ID to rent: "));
                    break;

                case 6:
                    store.purchaseMovie(readInt(scanner, "Enter Movie ID to purchase: "));
                    break;

                case 7: {
                    int restockId = readInt(scanner, "Enter Movie ID to restock: ");
                    int amount = readInt(scanner, "Enter amount to add to stock: ");
                    store.restockMovie(restockId, amount);
                    break;
                }

                case 8:
                    store.returnMovie(readInt(scanner, "Enter Movie ID to return: "));
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

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            }
            System.out.println("Invalid input. Please enter a whole number.");
            scanner.nextLine();
        }
    }

    private static double readDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            }
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
        }
    }

    private static int readNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            int value = readInt(scanner, prompt);
            if (value >= 0) return value;
            System.out.println("Value cannot be negative.");
        }
    }

    private static double readNonNegativeDouble(Scanner scanner, String prompt) {
        while (true) {
            double value = readDouble(scanner, prompt);
            if (value >= 0) return value;
            System.out.println("Value cannot be negative.");
        }
    }
}
