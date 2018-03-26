
/**
 * Write a description of class StudentPilotCertificate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public final class StudentPilotCertificate extends PilotCertificate
{
    
    public StudentPilotCertificate(java.time.LocalDate expiryDate, String holderName,java.time.LocalDate dateOfBirth,String regNo)
    {
        super(expiryDate, holderName, dateOfBirth, regNo);
    }

    public String getLicenseType(){
        return ("STUDENT PILOT LICENSE");
    }
}
