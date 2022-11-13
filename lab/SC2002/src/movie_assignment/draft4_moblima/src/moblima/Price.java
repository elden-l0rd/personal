package moblima;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unchecked")
public class Price {
	public double baseprice;
    public static Map<String, Double> priceMap = new HashMap<String, Double>();
    private static ArrayList<LocalDate> holiday = new ArrayList<LocalDate>();

    public static ArrayList<LocalDate> getHoliday() {
        return holiday;
    }

    public static void setHoliday(ArrayList<LocalDate> holiday) {
        Price.holiday = holiday;
    }

    public static void addHoliday(LocalDate addHoliday) {
        Price.holiday.add(addHoliday);
    }

    public static void editPriceMap(String type, double price) {
        priceMap.replace(type, price);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("price.dat");
            out = new ObjectOutputStream(fos);
            out.writeObject(priceMap);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(priceMap);
    }
    
    public static void setPriceMap() {
        priceMap.put("WeekdayRegularStandard", 9.00);
        priceMap.put("WeekendRegularStandard", 11.00);
        priceMap.put("Weekend3DStandard", 11.00);
        priceMap.put("Weekend3DStandard", 15.00);
        priceMap.put("WeekdayRegularPlatinum", 15.00);
        priceMap.put("WeekendRegularPlatinum", 20.00);
        priceMap.put("Weekend3DPlatinum", 20.00);
        priceMap.put("Weekend3DPlatinum", 25.00);
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream("price.dat");
            out = new ObjectOutputStream(fos);
            out.writeObject(priceMap);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readPriceMap() {
        FileInputStream fis = null;
        ObjectInputStream in = null;
        priceMap = new HashMap<String, Double>();
        try {
            fis = new FileInputStream("price.dat");
            in = new ObjectInputStream(fis);
            priceMap = (Map<String, Double>) in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        for (String s : priceMap.keySet()) {
            System.out.println(s);
        }
    }
    
    public static double calPrice(Ticket ticket) {
        double discount = 1;
        if (holiday.contains(ticket.getDate())) {
            discount = 1.5;
        }
        if (ticket.getCinema().getClass().toString().equals("STANDARD")) {
            DayOfWeek day = ticket.getDate().getDayOfWeek();
            if (ticket.getMovieChosen().getType().toLowerCase().equals("regular")) {
         
            	switch (day) {
	                case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY:
	                    return priceMap.get("WeekdayRegularStandard") * discount;
	                case FRIDAY: case SATURDAY: case SUNDAY: {
	                        return priceMap.get("WeekdayRegularStandard") * discount;
	                }
                }
            }
            if (ticket.getMovieChosen().getType().equals(ticket)) {

                switch (day) {
                    case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY:
                        return priceMap.get("Weekend3DStandard") * discount;
                    case FRIDAY: case SATURDAY: case SUNDAY: {
                            return priceMap.get("Weekend3DStandard") * discount;
                    }
                }
            }

        } else {
            DayOfWeek day = ticket.getDate().getDayOfWeek();
            if (ticket.getMovieChosen().getType().toLowerCase().equals("regular")) {
                switch (day) {
	                case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY:
	                    return priceMap.get("WeekendRegularPlatinum") * discount;
	                case FRIDAY: case SATURDAY: case SUNDAY: {
	                        return priceMap.get("WeekendRegularPlatinum") * discount;
	                }
                }
            }
            if (ticket.getMovieChosen().getType().toLowerCase().equals("3d")) {

                switch (day) {
	                case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY:
	                    return priceMap.get("Weekend3DPlatinum") * discount;
	                case FRIDAY: case SATURDAY: case SUNDAY: {
	                        return priceMap.get("Weekend3DPlatinum") * discount;
	                }
                }
            }


        }
        return 0;
    }
}


//INPUT 
//Movie movieChosen, Seat seat, Cineplex cineplex, Cinema cinema, LocalDate date, MovieSlot slot
//
//age, weekend, holiday, cinemaclass, 3D
//holiday
