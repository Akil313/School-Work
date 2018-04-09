public class Flight
{
    private String flightNumber;
    private String destination;
    private Package[] packages;
    private int numPackages;
    private String status;
    private String update;
    
    public Flight(String flightNumber, String destination)
    {
        this.flightNumber = flightNumber;
        this.destination = destination;
        packages = new Package[10];
        numPackages = 0;
        status = "On Time";
        
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
    
    public String toString()
    {
        return (flightNumber + " " + destination + " " + ".");
        
    }
    
    public boolean addPackage(String owner, double weight){
        Package pack;
        pack = new Package(destination, owner,weight);
        if(numPackages<10){
            packages [numPackages] = pack;
            numPackages++;
            return true;
        }else{
            return false;
        }
    }
    
    public boolean addPackage(String destination, String owner, double weight){
        System.out.println("3" + destination + owner + weight);
        Package pack;
        pack = new Package(destination, owner, weight);
        if(numPackages<10){
            packages [numPackages] = pack;
            numPackages++;
            return true;
        }else{
            return false;
        }
    }
    
    public String getPackageDetails(int ID){
        for(int x = 0; x<=numPackages; x++){
        if(packages[x].getPackageID() == ID){
            return packages[x].toString();
        }
    }
      return "null";
    }
    
    public String getPackageDetails(String owner){
        //for loop is needed here
        for(int y = 0; y<=numPackages; y++){
        if(packages[y].getOwner() .equals (owner)){
            return packages[y].toString();
        }
    }
            return "null";
    }
    
    public String getPackageManifest(){
        int o=0;
        while(!packages[o] .equals (null)){
            return packages[o].toString();
        }
        return null;
    }
    
    public void updatePackageManifest(){
       packages[0].setStatus(status);
    }
    
    public boolean updateStatus(char code){
        if(code == 'A'){
            status = "Arrived";
            return true;
        }
        if(code == 'D'){
            status = "Delayed";
            return true;
        }
        if(code == 'O'){
            status = "On Time";
            return true;
        }
        else{
            return false;
        }
    }
}
