/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

/**
 *
 * @author hkhat
 */
public class Book {

    private int bookId;
    private String bookName;
    private String author;
    private String bookLength;
    private int bookCopies;

    /**
     * No Argument Constructor for Book Class
     */
    public Book() {
        bookId = 0;
        bookName = "";
        author = "";
        bookLength = "";
        bookCopies = 0;
    }

    /**
     * All the argument constructor for book class
     *
     * @param bookId : ID for the book
     * @param bookName : Books Name
     * @param author : Books Author
     * @param bookLength : Books Length
     * @param bookCopies : The no of available of book copies
     */
    public Book(int bookId, String bookName, String author, String bookLength, int bookCopies) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.bookLength = bookLength;
        this.bookCopies = bookCopies;
    }

    /**
     * Gets book Id
     *
     * @return BookId as Int
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * Sets BookID
     *
     * @param bookId as int which you want to set
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    /**
     * Get Book's Name
     *
     * @return BookName as String
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * Set Books Name
     *
     * @param bookName as String which you want to set
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * Get the Author of the book
     *
     * @return Author as String
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Sets the Author of the Book
     *
     * @param author as String which you want to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * get Books Length
     *
     * @return bookLength as int
     */
    public String getBookLength() {
        return bookLength;
    }

    /**
     * Sets the Book Length
     *
     * @param bookLength as String which you want to set
     */
    public void setBookLength(String bookLength) {
        this.bookLength = bookLength;
    }

    /**
     * get Book Copies
     *
     * @return bookCopies as int
     */
    public int getBookCopies() {
        return bookCopies;
    }

    /**
     * Set Book Copies
     *
     * @param bookCopies as String which you want to set
     */
    public void setBookCopies(int bookCopies) {
        this.bookCopies = bookCopies;
    }

    /**
     * Override hashCode for bookID
     *
     * @return HashCode for BookId
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.bookId;
        return hash;
    }

    /**
     * Override equals method for book ID
     *
     * @param obj Book Obj
     * @return If the Object are equal
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Book other = (Book) obj;
        if (this.bookId != other.bookId)
        {
            return false;
        }
        return true;
    }

    /**
     * Prints the Book Class in a more readable way
     *
     * @return Class in a string format
     */
    @Override
    public String toString() {
        return "Book{" + "bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookLength=" + bookLength + ", bookCopies=" + bookCopies + '}';
    }

}
