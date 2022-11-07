package moblima;

import java.util.*;
import java.io.Serializable;
import java.time.LocalDate;

public class MovieSlot implements Serializable {
    private Seat[][] cinemaSeats; //A->J 1->8
    private LocalDate date;
    private String time;
    private Cinema cinema;
    private Cineplex cineplex;
    private CinemaClass cinemaClass;
    private Movie movie; //Movie Name
    
    public MovieSlot() {
        this.cinemaSeats = new Seat[10][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 10; k++) {
                cinemaSeats[k][i] = new Seat(k, i, false);
            }
        }
    }

    public MovieSlot(String time, Cinema cinema, Movie movie, LocalDate date) {
        this.cinemaSeats = new Seat[10][8];
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 10; k++) {
                cinemaSeats[k][i] = new Seat(k, i, false); 
            }
        }
        this.date = date;
        this.time = time;
        this.cinema = cinema;
        this.cineplex = cinema.getCineplex();
        this.cineplex.addSlots(this);
        this.cinemaClass = cinema.getCinemaclass();
        this.movie = movie;
    }

    public CinemaClass getCinemaClass() {
        return cinemaClass;
    }

    public void setCinemaClass(CinemaClass cinemaClass) {
        this.cinemaClass = cinemaClass;
    }

    public Cinema getCinema() {
        return cinema;
    }

    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public Cineplex getCineplex() {
        return cineplex;
    }

    public void setCineplex(Cineplex cineplex) {
        this.cineplex = cineplex;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Seat[][] getCinemaSeats() {
        return cinemaSeats;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat bookSeat(int r, int c) {
        this.cinemaSeats[r][c].setBooked();
        Seatprinter.printSeat(this.cinemaSeats);
        return this.cinemaSeats[r][c];

    }


}