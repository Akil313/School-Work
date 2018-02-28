//This class is used to hold the logic of the main functions presented to the user

public class PaketzustellungSystem{
    private Flight[] flights = new Flight[5];
    private int numFlights = 0;
    
    public boolean addPackage(String packageDestination, String owner, double weight){
        for(int x=0; x<numFlights; x++){
            if(packageDestination.equals(flights[x].getDestination())){
               flights[x].addPackage(owner, weight);
               return true;
            }
        }
        return false;
    }
    
    public boolean addFlight(String flightNumber, String flightDestination){
        if(numFlights < 5 && numFlights > -1){
            flights[numFlights] = new Flight(flightNumber, flightDestination);
            numFlights++;
            return true;
        }
        return false;
    }
    
    public Flight getFlightByDestination(String destination){
        for(int x=0; x<numFlights; x++){
            if(destination.equals(flights[x].getDestination())){
                return flights[x];
            }
        }
        return null;
    }
    
    public String listPackage(int ID){
        for(int x=0; x<numFlights; x++){
            if(!flights[x].getPackageDetails(ID).equals(null)){
                return flights[x].getPackageDetails(ID);
            }
        }
        return("There was no packages with that ID \n");
    }
    
    public String listPackages(String owner){
        String pString = new String(); 
        for(int x=0; x<numFlights; x++){
            if(!flights[x].getPackageDetails(owner).equals(null)){
                pString = pString + flights[x].getPackageDetails(owner) + "\n";
            }
        }
        
        if(pString.equals(null)){
            return("There were no packages to that owner \n");
        }
        return pString;
    }
    
    public String listPackages(){
        String pString = new String();
        for(int x=0; x<numFlights; x++){
            pString = pString + flights[x].getPackageManifest();
        }
        
        if(pString.equals(null)){
            return("No packages were found \n");
        }
        return pString;
    }
    
    public String listFlights(){
        if(numFlights == 0){
            return("No flights were found \n");
        }
        
        String fString = new String();
        for(int x=0; x<numFlights; x++){
            fString = fString + flights[x].toString() + "\n";
        }
        return fString;
    }
    
    public String updateFlightStatus(String flightNumber, char code){
        boolean check;
        for(int x=0; x<numFlights; x++){
            if(flightNumber.equals(flights[x].getFlightNumber())){
                check = flights[x].updateStatus(code);
                if(check == true){
                    return ("The flight status was updated");
                }
                return ("The flight status was not updated due to an invallid flught status code \n");
            }
        }
        return ("The flight status was not updated due to no flight existing with that flightNumber \n");
    }
}