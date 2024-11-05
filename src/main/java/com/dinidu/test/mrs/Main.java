package com.dinidu.test.mrs;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("1", "Harry Potter", "Drama", 1994, 100);
        Movie movi = new Movie("2", "Guardians of the Galaxy", "Sci-Fi", 2010, 200);
        Movie mov = new Movie("3", "Game of Thrones", "Action", 2000, 300);
        Movie mov2 = new Movie("4", "How to Train Your Dragon", "Thriller", 1900, 400);

        RegularCustomer regularCustomer = new RegularCustomer("1", "Tom", "tom@go.com");
        PremiumCustomer premiumCustomer = new PremiumCustomer("2", "Bob", "bob@go.com");

        System.out.println("= = = = Welcome to Movie Rental System = = = = ");
        System.out.println("Here are Available Movies: ");
        System.out.println("1 ]"+movie);
        System.out.println("2 ]"+movi);
        System.out.println("3 ]"+mov);
        System.out.println("4 ]"+mov2);

        System.out.println();
        regularCustomer.rentMovie(movie);
        regularCustomer.viewRentedMovies();

        System.out.println();
        regularCustomer.checkOverDueMovies();

        try {
            regularCustomer.returnMovie(movie);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        regularCustomer.viewRentedMovies();
        System.out.println();

        regularCustomer.checkOverDueMovies();
        System.out.println();

        regularCustomer.rentMovie(movi);
        premiumCustomer.viewRentedMovies();
        System.out.println();
        regularCustomer.checkOverDueMovies();
        System.out.println();
        try {
            regularCustomer.returnMovie(movi);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        regularCustomer.viewRentedMovies();
        System.out.println();
        premiumCustomer.checkOverDueMovies();
        System.out.println();
        regularCustomer.rentMovie(mov);
        premiumCustomer.viewRentedMovies();

    }
}
