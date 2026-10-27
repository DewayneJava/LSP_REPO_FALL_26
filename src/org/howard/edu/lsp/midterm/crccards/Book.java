package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a book and tracks whether it is available for borrowing.
 */
class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;
    /**
     * Creates a book that is initially available.
     *
     * @param isbn the book identifier
     * @param title the book title
     * @param author the book author
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        available = true;
    }
    /**
     * Returns the book identifier.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * Returns the book title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Returns the book author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * Reports whether this book can be borrowed.
     *
     * @return true if available, or false if borrowed
     */
    public boolean isAvailable() {
        return available;
    }
    /**
     * Marks this book as borrowed.
     *
     * @throws IllegalStateException if the book is already borrowed
     */
    public void borrowBook() {
       if (!available) {
           throw new IllegalStateException();
       }
       else {
           available = !available;
       }
    }
    /**
     * Marks this book as available.
     *
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException();
        }
        else {
            available = !available;
        }
    }
    /**
     * Returns the book details and current lending status.
     *
     * @return text in the format {@code B101 Effective Java by Joshua Bloch [AVAILABLE]},
     *         using {@code [BORROWED]} when unavailable
     */
    @Override
    public String toString() {
        return isbn + " " + title + " by " + author
                + " [" + (available ? "AVAILABLE" : "BORROWED") + "]";
    }
}

