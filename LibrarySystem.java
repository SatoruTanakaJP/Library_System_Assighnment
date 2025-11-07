
import java.util.*;


public class LibrarySystem {

    private static class Book {
        private final String title;
        private final String author;
        private int quantity;

        Book(String title, String author, int quantity) {
            this.title = title;
            this.author = author;
            this.quantity = quantity;
        }
        public String getTitle() { return title; }
        public String getAuthor() { return author; }
        public int getQuantity() { return quantity; }
        public void increase(int n) { quantity += n; }
        public boolean decreaseIfAvailable(int n) {
            if (n <= quantity) { quantity -= n; return true; }
            return false;
        }
        @Override
        public String toString() {
            return "\"" + title + "\" by " + author + " (available: " + quantity + ")";
        }
    }

    private final Map<String, Book> catalog = new HashMap<>();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new LibrarySystem().run();
    }

    private void run() {
        System.out.println("=== Welcome to the Library System ===");
        while (true) {
            printMenu();
            int choice = readMenuChoice();
            switch (choice) {
                case 1 -> addBook();
                case 2 -> borrowBook();
                case 3 -> returnBook();
                case 4 -> { 
                    System.out.println("Exiting... Goodbye!");
                    return; 
                }
                default -> System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }

    private void printMenu() {
        System.out.println("\nChoose an option:");
        System.out.println("1) Add Books");
        System.out.println("2) Borrow Books");
        System.out.println("3) Return Books");
        System.out.println("4) Exit");
        System.out.print("Enter choice: ");
    }

    private int readMenuChoice() {
        try {
            int c = Integer.parseInt(sc.nextLine().trim());
            return c;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // ----- Add Books -----
    private void addBook() {
        System.out.println("\n[Add Books]");
        String title = readNonEmptyLine("Enter book title: ");
        String author = readNonEmptyLine("Enter author: ");
        int qty = readPositiveInt("Enter quantity (positive integer): ");

        String key = title.toLowerCase();
        if (catalog.containsKey(key)) {
            catalog.get(key).increase(qty);
            System.out.println("Updated quantity. Now: " + catalog.get(key));
        } else {
            catalog.put(key, new Book(title, author, qty));
            System.out.println("Added: " + catalog.get(key));
        }
    }

    // ----- Borrow Books -----
    private void borrowBook() {
        System.out.println("\n[Borrow Books]");
        String title = readNonEmptyLine("Enter book title to borrow: ");
        int qty = readPositiveInt("Enter quantity to borrow: ");

        String key = title.toLowerCase();
        if (!catalog.containsKey(key)) {
            System.out.println("Error: \"" + title + "\" is not in the library.");
        } else {
            Book b = catalog.get(key);
            if (b.decreaseIfAvailable(qty)) {
                System.out.println("Success: Borrowed " + qty + " copy/copies of " + b.getTitle() + ".");
                System.out.println("Remaining stock: " + b.getQuantity());
            } else {
                System.out.println("Error: Not enough copies available. Current stock: " + b.getQuantity());
            }
        }
    }

    // ----- Return Books -----
    private void returnBook() {
        System.out.println("\n[Return Books]");
        String title = readNonEmptyLine("Enter book title to return: ");
        int qty = readPositiveInt("Enter quantity to return: ");

        String key = title.toLowerCase();
        if (!catalog.containsKey(key)) {
            System.out.println("Error: \"" + title + "\" does not belong to this library.");
        } else {
            Book b = catalog.get(key);
            b.increase(qty);
            System.out.println("Success: Returned " + qty + " copy/copies of " + b.getTitle() + ".");
            System.out.println("Current stock: " + b.getQuantity());
        }
    }

    // ----- Helpers -----
    private int readPositiveInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(line);
                if (n > 0) return n;
                System.out.println("Please enter a positive integer (> 0).");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.println("Input cannot be empty. Please try again.");
        }
    }
}
