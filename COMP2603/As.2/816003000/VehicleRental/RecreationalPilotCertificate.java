
/**
 * Write a description of class RecreationalPilotCertificate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class RecreationalPilotCertificate extends PilotCertificate
{
    private int hoursFlightTime = 60;
    
    public RecreationalPilotCertificate(java.time.LocalDate expiryDate, String holderName, java.time.LocalDate dateOfBirth, String regNo){
          super(expiryDate, holderName, dateOfBirth, regNo);
    }
    
    public String getLicenseType(){
        return ("RECREATIONAL PILOT LICENSE");
    }
    
    public void setHoursFlightTime(int hours){
        if(hours >= 60){
            this.hoursFlightTime = hours;
        }
    }
}
