
/* COMP2603 , COMP2500 Runner class for Assignment 2
 This class demonstrates how the classes in the Scapha-Rentalis Ltd program are meant to interact with other.
 Only a few test cases are included. Please edit and include more objects and test cases.
*/

import java.time.LocalDate; // Import statement for using a java.time.LocalDate object. Refer to API

public class Runner {
    
    public static void main(String[] args){
        
       //Create some Customer objects. (Insert more for testing)
       Customer c1  = new Customer("Jane Doe");
       Customer c2 = new Customer("Frank Smart");
       Customer c3 = new Customer("Larry King");
       Customer c4 = new Customer("John Walsh");
       Customer c5 = new Customer("John Welsh"); //deliberate spelling. This is a different customer
        
        
       //Create some Vehicle License objects. (Insert more for testing)
       VehicleLicense l1= new StudentPilotCertificate(LocalDate.of(2019,01,01), "Jane Doe", LocalDate.of(1956,10,11), "SP123");
       VehicleLicense l2 = new StudentPilotCertificate(LocalDate.of(2018,06,01), "Frank Smart", LocalDate.of(2001,03,15), "SP143");
       VehicleLicense l3 = new RecreationalPilotCertificate(LocalDate.of(2018,12,01), "John Walsh", LocalDate.of(1977,03,15), "PP193");
       VehicleLicense l4 = new StudentPilotCertificate(LocalDate.of(1989,02,01), "John Walsh", LocalDate.of(1977,03,15), "SP063");
        
        
       // Associate one or more Vehicle Licenses with a Customer. (Insert more for testing)
       c1.addLicense(l1);
       c2.addLicense(l2);
       c4.addLicense(l3);
       c4.addLicense(l4);
       c5.addLicense(l4);
        
       // Create some Vehicles for Scapha-Rentalis Ltd. (Insert more for testing)
       Vehicle v1 = new HotAirBalloon("HB100", "X-Wing 1738", 40);
       Vehicle v2 = new LightSportAircraft("LS410","Cessna 172G", 55);
       Vehicle v3 = new LightSportAircraft("LS610","Cessna 310", 60);
       
        //Create a few Rental Records that model various customers requests
       RentalRecord r = new RentalRecord(LocalDate.now(), LocalDate.of(2018,05,10), v1, c1);
       r.validate();            // validate the request
       System.out.println(r);   // print out the request details after validation
              
       RentalRecord r2 = new RentalRecord(LocalDate.now(), LocalDate.of(2018,05,10), v1, c2);
       r2.validate();
       System.out.println(r2);
       
       RentalRecord r3 = new RentalRecord(LocalDate.now(), LocalDate.of(2018,05,10), v2, c3);
       r3.validate();
       System.out.println(r3);
       
       RentalRecord r4 = new RentalRecord(LocalDate.now(), LocalDate.of(2018,05,10), v3, c4);
       r4.validate();
       System.out.println(r4);
       
       RentalRecord r5 = new RentalRecord(LocalDate.now(), LocalDate.of(2018,05,10), v3, c5);
       r5.validate();
       System.out.println(r5);
        
       //(Insert more for Rental Records testing)
        
        
        
    }
}
