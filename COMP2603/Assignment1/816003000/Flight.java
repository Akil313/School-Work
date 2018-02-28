// This cclass is for flights in the system. Each flight holding 10 packages

public class Flight{
    private String flightNumber;
    private String destination;
    private Package[] packages = new Package[10];
    private int numPackages=0;
    private String status = "On Time";
    
    public Flight(String flightNumber, String destination){
        this.flightNumber = flightNumber;
        this.destination = destination;
    }
    
    public String toString(){
        return ("Flight No. : " + flightNumber + " Destination: " + destination 
        + "\nStatus: " + status);
    }
    
    public boolean addPackage(String owner, double weight){
        if(owner != null && weight > 0 && numPackages<10){
            packages[numPackages] = new Package(destination, owner, weight);
            numPackages++;
            updatePackageManifest();
            return true;
        }
        System.out.println("Info is either invallid, missing or the flight is full");
        return false;
    }
    
    public String getPackageDetails(int ID){
        for(int x=0; x<numPackages; x++){
            if(packages[x].getID() == ID){
                return (packages[x].toString());
            }
        }
        return null;
    }
    
    public String getPackageDetails(String owner){
        String dets = new String();
        for(int x=0; x<numPackages; x++){
            if(packages[x].getOwner().equals(owner)){
                dets = dets + packages[x].toString() + "\n";
            }
        }
        return dets;
    }
    
    //Returns a string on the details of all the packages on a flight.
    public String getPackageManifest(){
        String dets = new String();
        for(int x=0; x<numPackages; x++){
            dets = dets + packages[x].toString() + "\n";
        }
        return dets;
    }
    
    //This function takes the status of a flight and uses it to update all the packages on the
    //flight to match the flight's status
    public void updatePackageManifest(){
        String fStatus = new String();
        
        if(status.equals("Arrived")){
                fStatus = "Pick Up";
        }else
        if(status.equals("Delayed")){
                fStatus = "Delayed";
        }else
        if(status.equals("On Time")){
                fStatus = "In Transit";
        }
        
        for(int x=0; x<numPackages; x++){
            packages[x].setStatus(fStatus);
        }
    }
    
    public boolean updateStatus(char code){
        if(code == 'A'){
            status = "Arrived";
            updatePackageManifest();
            return true;
        }else
        if(code == 'D'){
            status = "Delayed";
            updatePackageManifest();
            return true;
        }else
        if(code == 'O'){
            status = "On Time";
            updatePackageManifest();
            return true;
        }
        return false;
    }
    
    public String getFlightNumber(){
        return flightNumber;
    }
    public String getDestination(){
        return destination;
    }
    public int getNumPackages(){
        return numPackages;
    }
    public String getStatus(){
        return status;
    }
}