// Base class
public class Reservation {
    private String name;
    private int age;
    private int flightClass;

    public Reservation(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getFlightClass() {
        return flightClass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
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
