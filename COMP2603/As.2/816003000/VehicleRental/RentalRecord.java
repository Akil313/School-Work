import java.time.Period;
/**
 * Write a description of class RentalRecord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class RentalRecord
{
    Customer customer;
    Vehicle vehicle;
    java.time.LocalDate startDate;
    java.time.LocalDate endDate;
    long numDays;
    double rentalCost;
    String statusMessage = new String();
    
    public RentalRecord(java.time.LocalDate s, java.time.LocalDate e, Vehicle v, Customer c)
    {
        startDate = s;
        endDate = e;
        vehicle = v;
        customer = c;
    }

    private void calculateNumDays(){
        Period p = startDate.until(endDate);
        numDays = p.getDays();
    }
    
    private void calculateCost(){
        rentalCost = vehicle.getDailyRentalRate() * numDays;
    }
    
    private String accessLicense(){
        if(!customer.hasLicense()){
            return "No license - cannot rent " + vehicle.getType();
        }
        
        java.util.ArrayList<VehicleLicense> licenses = customer.getLicense();
        boolean correctLicense = false;
        
        int position = 0;
        for(VehicleLicense l: licenses){
            if(l.getLicenseType().contains("PILOT LICENSE")){
                correctLicense = true;
                break;
            }
            position = position + 1;
        }
        
        if(correctLicense == false){
            return "Incorrect license "+ licenses.get(position-1).getLicenseType() + " to operate " + vehicle.getType();
        }
        
        if(!vehicle.canBeOperated(licenses.get(position))){
            System.out.println(vehicle.getLicenseError(licenses.get(position)));
            return vehicle.getLicenseError(licenses.get(position));
        }
        
        return "Rental Approved";
    }
    
    public void validate(){
        if(accessLicense().equals("Rental Approved")){
            calculateNumDays();
            calculateCost();
        }
        statusMessage = accessLicense();
    }
    
    public String toString (){
        return customer.toString() + "\n" + vehicle.toString() + "\nStart Date: " + startDate.toString() + " End Date: " + endDate.toString() + 
               "\nLength of rental: " + this.numDays + " Rental Cost: " + rentalCost + " Status message: " + statusMessage + "\n";
    }
}
