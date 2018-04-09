public class PaketzustellungSystem
{
    // instance variables - replace the example below with your own
    private Flight[] flights;
    private int numFlights;

    public PaketzustellungSystem()
    {
        flights = new Flight[5];
        numFlights = 0;
    }

    public int getNumflights(){
        return numFlights;
    }
    
    public boolean addPackage(String packageDestination, String owner, double weight){
        if(numFlights <= 5){
            System.out.println("2" + packageDestination + owner + weight);
            boolean i = flights[numFlights].addPackage(packageDestination, owner, weight);
            numFlights++;
            return i;
        }
        return false;
    }
    
    public boolean addFlight(String flightNumber, String flightDestination){
        //Ch
        Flight fly = new Flight(flightNumber, flightDestination);
        flights[numFlights] = fly;
        numFlights ++;
        return true;
    }
    
    public Flight getFlightByDestination(String destination){
        for(int i = 0; i<numFlights; i++){
            if(flights[i].getDestination() .equals(destination)){
                return flights[i];
            }
        }
        return null;
    }
    
    public String listPackage(int ID){
        if(numFlights>0 && numFlights<=5){
            for (int m = 0; m<numFlights; m++){
                String list = flights[m].getPackageDetails(ID);
                
                if(!list .equals(null)){
                    return list;
                }
            }
        }
        return "The package was not found.";
    }

    public String listPackages(String owner){
        if(numFlights>0 && numFlights<=5){
            for (int k = 0; k<numFlights; k++){
                String list2 = flights[k].getPackageDetails(owner);
                
                if(!list2 .equals(null)){
                    return list2;
                }
            }
        }
        return "The packages by this owner could not be found";
    }
    
    public String listPackages(){
        if(numFlights>0 && numFlights<=5){
            for(int l = 0; l<numFlights; l++){
                String list3 = flights[l].getPackageManifest();
                
                if(!list3 .equals(null)){
                    return list3;
                }
            }
        }
        return "There is no packages.";
    }
    
    public String listFlights(){
        if(numFlights > 0){
            for (int f = 0; f<numFlights; f++){
                String list4 = flights[f].toString();
                
                if(!list4 .equals (null)){
                    return list4;
                }
            }
        }
        return "There is no flight.";
    }
    
    public String updateFlightStatus(String flightNumber, char code){
        if(numFlights!=0){
            for(int t = 0; t<numFlights; t++){
                if(flightNumber .equals(flights[t].getFlightNumber())){
                    boolean up = flights[t].updateStatus(code);
                    return "The Flight has succesfully been updated.";
                }
            }
        }
        return "The Flight has unsuccessfully been updated.";
    }
}

