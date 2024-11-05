package com.dinidu.test.lms;

public class Book {
    private String bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(String bookId, String title, String author, String genre) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }
    public Book setBookId(String bookId) {
        this.bookId = bookId;
        return this;
    }
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public Book setGenre(String genre) {
        this.genre = genre;
        return this;
    }
    public Book setAuthor(String author) {
        this.author = author;
        return this;
    }
    public Book setTitle(String title) {
        this.title = title;
        return this;
    }
    public String getBookId() {
        return bookId;
    }
    public String getGenre() {
        return genre;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book [" +
                "bookId = '" + bookId + '\'' +
                ", title = '" + title + '\'' +
                ", author = '" + author + '\'' +
                ", genre = '" + genre + '\'' +
                ", isAvailable = " + isAvailable +
                ']';
    }

}
