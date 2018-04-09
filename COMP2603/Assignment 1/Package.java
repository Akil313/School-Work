public class Package
{
    private int packageID;//=1
    private double weight;
    private String destination;
    private String owner;
    private String status;
    private static int packageIDGenerator = 1;

    
    public Package(String destination, String owner, double weight)
    {
        this.destination = destination;
        this.owner = owner;
        this.weight = weight;
        status = "In Transit";
        packageID = packageIDGenerator;
        packageIDGenerator++;
        //packageID= this.packageid
        //this.packageID++
    }

    public String getDestination(){
        return destination;
    }
    
    public int getPackageID(){
        return packageID;
    }
    
    public double getWeight(){
        return weight;
    }
    
    public String getOwner(){
        return owner;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String flightStatus){
        if(flightStatus .equals ("On Time")){
            status = "In Transit";
        }
        if(flightStatus .equals ("Arrived")){
            status = "Pick up";
        }
        if(flightStatus .equals ("Delayed")){
            status = "Delayed";
        }
    }
    public String toString()
    {
        return (destination + " " + owner + " " + weight + ".");
        
    }

    /*public static void main(String args[]){
            Package test1 = new Package ("destined","man",23.5);
            Flight f1=new Flight ("412","destined");
            System.out.println(f1.addPackage("man",23.5));
            System.out.println(f1.addPackage("destined","man",23.6));
            System.out.println(test1.toString());
        }*/
}
