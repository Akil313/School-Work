//This class holds the packages than can be put on na specific flight.

public class Package{
    private int packageID;
    private double weight;
    private String destination;
    private String owner;
    private String status;
    private static int pacIDGenerator = 1;
    
    public Package(String destination, String owner, double weight){
        this.weight = weight;
        this.destination = destination;
        this.owner = owner;
        packageID = pacIDGenerator;
        pacIDGenerator++;
    }
    
    public String toString(){
        return ("ID: " + packageID + " Weight: " + weight +
        "kg\nDestination: " + destination + "\nOwner: " + owner + " Status: "
        + status + "\n");
    }
    
    public int getID(){
        return packageID;
    }
    public double getWeight(){
        return weight;
    }
    public String getDestination(){
        return destination;
    }
    public String getOwner(){
        return owner;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        if (status.equals("In Transit") || status.equals("Delayed") || status.equals("Pick Up")){
            this.status = status;
        }else{
            this.status = "Invalid Status";
        }
    }
}