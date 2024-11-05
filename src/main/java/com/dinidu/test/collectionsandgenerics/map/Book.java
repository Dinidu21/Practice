package com.dinidu.test.collectionsandgenerics.map;

public class Book<T,U> {
    private T bookTitle;
    private U bookISBN;

    public Book(T bookTitle, U bookISBN) {
        this.bookTitle = bookTitle;
        this.bookISBN = bookISBN;
    }
    public T getBookTitle() {
        return bookTitle;
    }
    public Book<T, U> setBookTitle(T bookTitle) {
        this.bookTitle = bookTitle;
        return this;
    }
    public U getBookISBN() {
        return bookISBN;
    }
    public Book<T, U> setBookISBN(U bookISBN) {
        this.bookISBN = bookISBN;
        return this;
    }
}
