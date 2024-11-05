package com.dinidu.test.lms;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public List<Book> searchBook(String searchTerm) {
        List<Book> searchResults = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase()))
            {
                System.out.println("Book found: " + book.getTitle() + " by " + book.getAuthor());
                searchResults.add(book);
            }
        }

        if (searchResults.isEmpty()) {
            System.out.println("No books found for: " + searchTerm);
        }
        return searchResults;
    }



    public void borrowBook(Member member,Book book) throws Exception {
        if(book.isAvailable()){
            member.borrowBook(book);
        }else {
            throw new Exception("Book is not available");
        }
    }

    public void returnBook(Member member, Book book) throws Exception {
        if(member.getBorrowedBooks().contains(book)){
            System.out.println(book.getTitle() + " returned successfully by " + member.getName());
            member.returnBook(book);
        }else {
            throw new Exception("Book is not borrowed by this member");
        }
    }

    public void printBorrowedBooks(Member member) {
        System.out.println("Books borrowed by " + member.getName() + ":");
        for(Book book : member.getBorrowedBooks()){
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }

    public Member getMemberById(String memberId) {
        for(Member member : members){
            if(member.getMemberId().equals(memberId)){
                return member;
            }
        }
        return null;
    }

    public Book getBookById(String bookId) {
        for(Book book : books){
            if(book.getBookId().equals(bookId)){
                return book;
            }
        }
        return null;
    }

    public Book[] getBooks() {
        return books.toArray(new Book[0]);
    }
}
