
/**
 * Write a description of class Customer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Customer
{
    String customerName = new String();
    java.util.ArrayList<VehicleLicense> licenses = new java.util.ArrayList<VehicleLicense>();

    public Customer(String customerName)
    {
        this.customerName = customerName;
    }
    
    public void addLicense(VehicleLicense vl){
        if(vl.getLicenseHolderName().equals(customerName)){
            licenses.add(vl);
        }
    }
    
    public boolean hasLicense(){
        return !licenses.isEmpty();
    }
    
    public java.util.ArrayList getLicense(){
        return licenses;
    }
    
    public String toString(){
        String s = new String();
        s = "Customer Name: " + customerName + "\nTypes of licenses:";
        
        if(licenses.isEmpty()){
            s = s + " " + "No license";
        }else{
            for (VehicleLicense vlT: licenses){
                s = s + " " + vlT.getLicenseType() + ",";
            }
        }
        s = s + "\n"; 
        return s;
    }
}
