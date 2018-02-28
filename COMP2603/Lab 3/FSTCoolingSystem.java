
public class FSTCoolingSystem{
   public static void main(String[] args){
    
     // Declare and instantiate your array of Room objects
     Room[] rArr = new Room[10];
     
     // Create and add Room objects to your array
     rArr[0] = new Room ("Lecture Room 1", 1, 120);
     rArr[1] = new Room ("Computer Science Lab 1", 2, 100);
     rArr[2] = new Room ("Computer Science Lab 2", 1, 150);
     rArr[3] = new Room ("Lecture Room 2", 1, 300);
     
     // Loop through the array and invoke the toString( ) method of the Room objects
     for (int x=0; x<4; x++){
         System.out.println(rArr[x].toString());
     }
     
     AirConditioner ac1 = new AirConditioner("Carrier", 5000);
     for(int x=0; x<4; x++){
         if(rArr[x].getRoomID().equals("103")){
             ac1.cools(rArr[x]);
             break;
         }
     }
     
     System.out.println(rArr[3].getRoomID());
     ac1.cools(rArr[3]);
     System.out.println(ac1.listRoom());
   }
}