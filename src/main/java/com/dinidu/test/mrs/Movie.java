package com.dinidu.test.mrs;

class Movie {
    private String movieID;
    private String title;
    private String genre;
    private int releaseYear;
    private double rentalPrice;
    private boolean isAvailable;

    public Movie(String movieID, String title, String genre, int releaseYear, double rentalPrice) {
        this.movieID = movieID;
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rentalPrice = rentalPrice;
        this.isAvailable = true;
    }

    public String getMovieID() { return movieID; }
    public String getTitle() { return title; }
    public String getGenre() { return genre; }
    public int getReleaseYear() { return releaseYear; }
    public double getRentalPrice() { return rentalPrice; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Movie: " + title + " (" + releaseYear + ") - " + genre + " - " + rentalPrice + "$";
    }
}