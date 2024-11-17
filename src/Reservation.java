// Base class
public class Reservation {
    protected String name;
    protected int flightClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(int flightClass) {
        this.flightClass = flightClass;
    }

//    public String FlightClass(int flightClass){
//        if(flightClass == 1){
//            return "Business";
//        }else if(flightClass == 2){
//            return "Economy";
//        }else {
//            return "Invalid Flight Class";
//        }
//    }
}
