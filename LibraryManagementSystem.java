import java.util.*;

public class LibraryManagementSystem {

    // Book class
    static class Book {
        private String title;
        private String author;
        private boolean isIssued;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
            this.isIssued = false;
        }

        public String getTitle() {
            return title;
        }

        public boolean isIssued() {
            return isIssued;
        }

        public void issueBook() {
            this.isIssued = true;
        }

        public void returnBook() {
            this.isIssued = false;
        }

        @Override
        public String toString() {
            return title + " by " + author + (isIssued ? " [Issued]" : " [Available]");
        }
    }

    // User class (not used much but included for structure)
    static class User {
        private int id;
        private String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User ID: " + id + ", Name: " + name;
        }
    }

    // Library class
    static class Library {
        private ArrayList<Book> books = new ArrayList<>();

        public void addBook(Book book) {
            books.add(book);
        }

        public void showBooks() {
            if (books.isEmpty()) {
                System.out.println("No books in library.");
                return;
            }
            for (Book b : books) {
                System.out.println(b);
            }
        }

        public void issueBook(String title) {
            for (Book b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    if (!b.isIssued()) {
                        b.issueBook();
                        System.out.println("Book issued: " + b.getTitle());
                        return;
                    } else {
                        System.out.println("Book already issued.");
                        return;
                    }
                }
            }
            System.out.println("Book not found.");
        }

        public void returnBook(String title) {
            for (Book b : books) {
                if (b.getTitle().equalsIgnoreCase(title)) {
                    if (b.isIssued()) {
                        b.returnBook();
                        System.out.println("Book returned: " + b.getTitle());
                        return;
                    } else {
                        System.out.println("Book was not issued.");
                        return;
                    }
                }
            }
            System.out.println("Book not found.");
        }
    }

    // Main method
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        // Adding some default books
        library.addBook(new Book("Chha Mana Atha Guntha ", "Fakir Mohan Senapati"));
        library.addBook(new Book("Matira Manisha", "Kalindi Charan Panigrahi"));
        library.addBook(new Book("Yajnaseni", "Pratibha Ray"));
        library.addBook(new Book("Amruta Phala", "Manoj Das"));
        library.addBook(new Book("Nila Saila", "Surendra Mohanty"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Show all books");
            System.out.println("2. Issue a book");
            System.out.println("3. Return a book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String titleToIssue = sc.nextLine();
                    library.issueBook(titleToIssue);
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String titleToReturn = sc.nextLine();
                    library.returnBook(titleToReturn);
                    break;
                case 4:
                    System.out.println("Exiting Library System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
