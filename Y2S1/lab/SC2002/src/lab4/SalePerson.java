package lab4;

public class SalePerson implements Comparable<Object>{
    private String firstName;
    private String lastName;
    private int totalSales;

    public SalePerson(String firstN, String lastN, int totalS) {
        firstName = firstN;
        lastName = lastN;
        totalSales = totalS;
    }

    public String toString() {
        return lastName+", "+firstName+" : "+totalSales;
    }

    public boolean equals(Object o) {
        if (o instanceof SalePerson) {
            SalePerson person = (SalePerson)o;
            if (person.getFirstName()==firstName && person.getLastName()==lastName)
                return true;
            else return false;
        }
        else return false;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof SalePerson) {
            SalePerson person = (SalePerson)o;
            if (person.getTotalSales()-totalSales == 0)
                return person.getLastName().compareTo(lastName);
            else return totalSales-person.getTotalSales();
        }
        else return -1;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getTotalSales() {
        return totalSales;
    }
}
