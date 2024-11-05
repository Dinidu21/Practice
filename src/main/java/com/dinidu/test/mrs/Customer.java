package com.dinidu.test.mrs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Customer {
    protected String customerID;
    protected String name;
    protected String email;
    protected List<Rental> rentedMovies;

    public Customer(String customerID, String name, String email) {
        this.customerID = customerID;
        this.name = name;
        this.email = email;
        this.rentedMovies = new ArrayList<>();
    }

    public String getCustomerID() { return customerID; }
    public String getName() { return name; }

    public abstract void rentMovie(Movie movie);

    public void viewRentedMovies() {
        if (rentedMovies.isEmpty()) {
            System.out.println(name + " has no rented movies.");
        } else {
            System.out.println(name + "'s Rented Movies:");
            for (Rental rental : rentedMovies) {
                System.out.println(rental);
            }
        }
    }

    public void returnMovie(Movie movie) throws Exception {
        Rental rental = findRentedMovie(movie);
        if (rental != null) {
            rentedMovies.remove(rental);
            movie.setAvailable(true);
            System.out.println(name + " successfully returned " + movie.getTitle());
        }else {
            throw new Exception("Movie not rented by " + name + ".");
        }
    }

    public Rental findRentedMovie(Movie movie) {
        for (Rental rental : rentedMovies) {
            if (rental.getMovie().getMovieID().equals(movie.getMovieID())) {
                return rental;
            }
        }
        return null;
    }

    public void checkOverDueMovies() {
        Date currentDate = new Date();
        for (Rental rental : rentedMovies) {
            if (rental.isOverdue()) {
                System.out.println(rental.getMovie().getTitle() + " is overdue.");
            }
        }
    }
}
