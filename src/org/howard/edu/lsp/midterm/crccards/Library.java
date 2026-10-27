package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Stores books with unique ISBNs and manages lending with a three-book limit.
 * Each library maintains its own collection.
 */
public class Library {
    private static final int MAX_BORROWED_BOOKS = 3;
    private final List<Book> library = new ArrayList<>();

    /**
     * Adds a book without replacing an existing book with the same ISBN.
     *
     * @param book the book to add; must be non-null and have a non-null ISBN
     * @throws IllegalArgumentException if the ISBN is already in the library
     */
    public void addBook(Book book) {
        if (findBook(book.getIsbn()) != null) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }
        library.add(book);
    }

    /**
     * Finds a stored book by an exact ISBN match.
     *
     * @param isbn the ISBN to find
     * @return the stored book object, or null if no match exists
     */
    public Book findBook(String isbn) {
        for (Book book : library) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Borrows a book if fewer than three books are currently borrowed.
     *
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if the ISBN is not in the library
     * @throws IllegalStateException if the book is already borrowed or the
     *         borrowing limit has been reached
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Unknown ISBN: " + isbn);
        }
        if (getBorrowedBookCount() >= MAX_BORROWED_BOOKS) {
            throw new IllegalStateException("Cannot borrow more than three books.");
        }
        book.borrowBook();
    }

    /**
     * Returns a borrowed book to available status.
     *
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if the ISBN is not in the library
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Unknown ISBN: " + isbn);
        }
        book.returnBook();
    }

    /**
     * Collects all books that are currently available.
     *
     * @return a new list containing the available book objects, or an empty list
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : library) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * Finds books by an exact, case-sensitive author match, including borrowed books.
     *
     * @param author the author name to match
     * @return a new list of matching book objects, or an empty list
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : library) {
            if (book.getAuthor().equals(author)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    /**
     * Retrieves all books in ascending lexicographic ISBN order without
     * changing the library's stored order.
     *
     * @return a new sorted list containing the stored book objects
     */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> sortedBooks = new ArrayList<>(library);
        sortedBooks.sort(Comparator.comparing(Book::getIsbn));
        return sortedBooks;
    }

    /**
     * Counts borrowed books using their current availability.
     *
     * @return the number of books that are unavailable
     */
    public int getBorrowedBookCount() {
        int borrowedCount = 0;
        for (Book book : library) {
            if (!book.isAvailable()) {
                borrowedCount++;
            }
        }
        return borrowedCount;
    }
}

