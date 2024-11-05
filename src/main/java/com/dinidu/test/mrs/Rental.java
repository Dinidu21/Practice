package com.dinidu.test.mrs;

import java.time.LocalDate;
import java.util.Date;

public class Rental {

    private Movie movie;
    private LocalDate rentalDate;
    private int rentalDays;

    public Rental(Movie movie, int rentalDays, LocalDate rentalDate) {
        this.movie = movie;
        this.rentalDate = rentalDate;
        this.rentalDays = rentalDays;
    }

    public Movie getMovie() { return movie; }
    public boolean isOverdue() { return LocalDate.now().isAfter(rentalDate.plusDays(rentalDays)); }

    @Override
    public String toString() {
        return "Rental { " +
                "movie = " + movie +
                ", rentalDate = " + rentalDate +
                ", rentalDays = " + rentalDays +
                '}';
    }
}
