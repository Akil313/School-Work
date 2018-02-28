public class Room{
   
    private String name;
    private int floor;
    private double squareFootage;
    private String roomID;
    private int numSeats;
    private AirConditioner airConditioner;
    
    public void addAirConditioner(AirConditioner ac){
        airConditioner = ac;
    }
    
    public String listAirConditioner(){
        if(airConditioner == null){
            return "No Air Conditioner Installed";
        }
        return airConditioner.toString();
    }
    
    public Room(String name, int floor, double squareFootage ){
        this.name = name;
        this.floor = floor;
        this.squareFootage = squareFootage;
        roomID = "FST";
        setNumSeats();
    }
    
    public Room(String name, int floor, double squareFootage, int numSeats){
        this.name = name;
        this.floor = floor;
        this.squareFootage = squareFootage;
        this.numSeats = numSeats;
        roomID = "FST";
    }
    
    private void setNumSeats( ){
        float seats = (float)squareFootage * 9/20;
        numSeats = java.lang.Math.round(seats);
    }
     
    public String getRoomID(){
         return roomID;
    }
    
    public String toString(){
       String details = "Room : " + name + " Floor: " + floor + " " + squareFootage + "sq ft.  Num Seats: " + numSeats; 
         return details;
    }
}
    

