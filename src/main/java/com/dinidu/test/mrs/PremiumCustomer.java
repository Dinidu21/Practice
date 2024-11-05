package com.dinidu.test.mrs;

import java.time.LocalDate;

public class PremiumCustomer extends Customer{
    final int MAX_RENTAL_DAYS = 14;


    public PremiumCustomer(String customerID, String name, String email) {
        super(customerID, name, email);
    }

    @Override
    public void rentMovie(Movie movie) {
        if(movie.isAvailable()){
            rentedMovies.add(new Rental(movie, MAX_RENTAL_DAYS, LocalDate.now()));
            movie.setAvailable(false);
            System.out.println("Successfully Rented " + movie.getTitle()+" for "+MAX_RENTAL_DAYS+" days "+" from "+LocalDate.now());
        }
        else{
            System.out.println("Movie Not Available");
        }
    }
}
