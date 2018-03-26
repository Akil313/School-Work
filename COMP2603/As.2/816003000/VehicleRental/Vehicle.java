
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Vehicle
{
    // instance variables - replace the example below with your own
    private String registrationNo = new String();
    private String type = new String();
    private double dailyRentalRate;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle(String regNo, String type, double rate)
    {
        registrationNo = regNo;
        this.type = type;
        dailyRentalRate = rate;
    }
    
    public double getDailyRentalRate(){
        return dailyRentalRate;
    }
    
    public String toString(){
        String s = new String();
        
        s = "Vehicle Number: " + registrationNo + " Vehicle Type: " + type;
        return s;
    }
    
    public abstract boolean canBeOperated(VehicleLicense vl);
    
    public abstract String getLicenseError(VehicleLicense vl);
    
    public String getType(){
        return type;
    }
}
