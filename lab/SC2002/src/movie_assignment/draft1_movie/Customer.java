package moblima;

import java.util.*;

public class Customer {
    private String name;
    private String mobile;
    private String email;
    private ArrayList<Ticket> bookingHistory;

    public Customer(String name, String mobile, String email, ArrayList<Ticket> bookingHistory) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.bookingHistory = bookingHistory;
    }

    public Customer() {
        bookingHistory = new ArrayList<Ticket>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void setBookingHistory(ArrayList<Ticket> bookingHistory) {
        this.bookingHistory = bookingHistory;
    }
    
    public ArrayList<Ticket> getBookingHistory() {
        return bookingHistory;
    }
}