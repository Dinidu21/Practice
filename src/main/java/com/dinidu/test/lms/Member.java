package com.dinidu.test.lms;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberId;
    private String name;
    private String email;
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String memberID, String name, String email) {
        this.memberId = memberID;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }
    public Member setMemberId(String memberId) {
        this.memberId = memberId;
        return this;
    }
    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public Member setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public Member setEmail(String email) {
        this.email = email;
        return this;
    }
    public String getName() {
        return name;
    }
    public Member setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Member{" +
                "borrowedBooks=" + borrowedBooks +
                ", memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        book.setAvailable(false);
    }
    public void returnBook(Book book) {
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }
}
