
/**
 * Write a description of class PilotCertificate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class PilotCertificate implements VehicleLicense
{
    private java.time.LocalDate expiryDate;
    private String holderName = new String();
    private java.time.LocalDate dateOfBirth;
    private String registrationNo = new String();
    private int hoursFlightTime;
    

    public PilotCertificate(java.time.LocalDate expiryDate, String holderName, java.time.LocalDate dateOfBirth, String regNo){
          this.expiryDate = expiryDate;
          this.holderName = holderName;
          this.dateOfBirth = dateOfBirth;
          registrationNo = regNo;
    }
    
    public boolean isExpired(){
        java.time.LocalDate curr = java.time.LocalDate.now();
        
        return !expiryDate.isAfter(curr);
    }
    
    public String getLicenseHolderName(){
        return holderName;
    }
    
    public int getLicenseHolderAge(){
        java.time.LocalDate curr = java.time.LocalDate.now();
        int years = curr.getYear() - dateOfBirth.getYear() -1;
        
        if(curr.getMonthValue() > dateOfBirth.getMonthValue()){
            years = years + 1;
        }else
        if(curr.getMonthValue() == dateOfBirth.getMonthValue()){
            if(curr.getDayOfMonth() >= dateOfBirth.getDayOfMonth()){
                years = years + 1;
            }
        }
        
        return years;
    }
    
    public String getLicenseRegistrationNo(){
        return registrationNo;
    }
    
    public int getHoursFlightTime(){
        return hoursFlightTime;
    }
    
    public String getLicenseType(){
        return ("PILOT LICENSE");
    }
}
