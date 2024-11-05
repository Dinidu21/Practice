package com.dinidu.test.collectionsandgenerics.map;

import java.util.HashMap;

public class Library {
    public static void main(String[] args) {
        HashMap<Integer, Book<?,?>> booksList = new HashMap<>();
        Book<String, String> book1 = new Book<>( "Harry Potter","ISBN-123");
        booksList.put(1, book1);
        Book<String, Integer> book2 = new Book<>("Harry Potter 2",123456);
        booksList.put(2, book2);

        for(int id : booksList.keySet()) {
            Book<?,?> book = booksList.get(id);
            System.out.println("Book Id : " + id+" Title : "+ book.getBookTitle() + " | ISBN : "+ book.getBookISBN());
        }
    }
}
