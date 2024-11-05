package com.dinidu.test.lms;

import java.util.List;
import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("============ Welcome to Library Management System =========");
        try {
            Library library = new Library();
            //Add Books
            Book book1 = new Book("B001", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction");
            Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Fiction");
            Book book3 = new Book("B003", "The Catcher in the Rye", "Harper Lee", "Fiction");

            library.addBook(book1);
            library.addBook(book2);
            library.addBook(book3);

            System.out.println("Here are the books in the library: ");
            for (Book book : library.getBooks()) {
                System.out.println("=> " + book.toString());
            }
            System.out.println();

            //Add Members
            Member member1 = new Member("M001", "John Doe", "vM7YI@example.com");
            Member member2 = new Member("M002", "James Bond", "vM7YI@example.com");
            library.addMember(member1);
            library.addMember(member2);

            // Search for a book by title or author
            List<Book> searchResults = library.searchBook("Harper Lee");  // Searching by author

            for (int i = 0; i < searchResults.size(); i++) {
                Book book = searchResults.get(i);
                System.out.println((i + 1) + ". " + book.getTitle() + " by " + book.getAuthor());
            }

            System.out.println();

            // Ask the user to select which book to borrow
            System.out.println("Enter the number of the book you want to borrow: ");
            int bookChoice = sc.nextInt() - 1; // Get user's choice (index starts from 0)

            Book selectedBook = null;
            if (bookChoice >= 0 && bookChoice < searchResults.size()) {
                selectedBook = searchResults.get(bookChoice);

                // Attempt to borrow the selected book
                try {
                    library.borrowBook(member1, selectedBook);
                    System.out.println("Successfully borrowed " + selectedBook.getTitle() + " by " + selectedBook.getAuthor());
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                System.out.println("Invalid choice.");
            }
            System.out.println();
            library.printBorrowedBooks(member1);
            System.out.println();
            // Return a book
            library.returnBook(member1, selectedBook);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
