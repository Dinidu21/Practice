package com.dinidu.test.mrs;

import java.time.LocalDate;

public class RegularCustomer extends Customer{
    final int MAX_RENTAL_DAYS = 7;


    public RegularCustomer(String customerID, String name, String email) {
        super(customerID, name, email);
    }

    @Override
    public void rentMovie(Movie movie) {
        if(movie.isAvailable()){
            rentedMovies.add(new Rental(movie,MAX_RENTAL_DAYS , LocalDate.now()));
            movie.setAvailable(false);
            System.out.println("Successfully Rented " + movie.getTitle()+" for "+MAX_RENTAL_DAYS+" days "+" from "+LocalDate.now());
        }
        else{
            System.out.println("Movie Not Available");
        }
    }

}
