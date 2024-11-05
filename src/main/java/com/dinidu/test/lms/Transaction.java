package com.dinidu.test.lms;

import java.time.LocalDate;

public class Transaction {
    private Member member;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Transaction(Member member, Book book) {
        this.member = member;
        this.book = book;
        this.borrowDate = LocalDate.now();
    }

    public void returnBook(){
        this.returnDate = LocalDate.now();
    }

    public boolean isOverdue(){
        return LocalDate.now().isAfter(borrowDate.plusDays(14));
    }

}
