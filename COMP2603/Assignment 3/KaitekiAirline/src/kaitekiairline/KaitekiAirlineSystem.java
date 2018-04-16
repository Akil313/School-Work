/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaitekiairline;
import java.util.*;
/**
 *
 * @author Akil313
 */
public class KaitekiAirlineSystem {
    
    HashMap<String, Passenger> passengers = new HashMap<>();
    HashMap<String, Flight> flights = new HashMap<>();
    HashMap<Passenger, BoardingPass> boardingPasses = new HashMap<>();
    
    public  KaitekiAirlineSystem(){
        Flight f = new Flight("NA412", "MIA", "TTO");
        flights.put(f.getNo(), f);
    }
    
    public String addPassenger(String firstName, String lastName, String passportNo, String flightNo){
        Passenger pass = new Passenger(firstName, lastName, passportNo);
        passengers.put(pass.getPassNo(), pass);
        
        return passengers.get(passportNo).getFirstName();
    }
    
    public String updatePassenger(String firstName, String lastName, String passportNo, String flightNo){
        Passenger pass = passengers.get(passportNo);
        
        pass.setFirstName(firstName);
        pass.setLastName(lastName);
        
        passengers.replace(passportNo, pass);
        return firstName;
    }
    
    public ArrayList<String> findPassenger(String passportNo){
        ArrayList<String> name = new ArrayList<>();
        
        Passenger pass = passengers.get(passportNo);
        name.add(pass.getFirstName());
        name.add(pass.getLastName());
        
        return name;
    }
    
    public String issueBoardingPass(String passportNo, String flightNo){
        Passenger pass = passengers.get(passportNo);
        Flight f = flights.get(flightNo);
        
        if(pass != null && f != null){
            String emptySeat = f.getEmptySeat();
            if(emptySeat != null){
                BoardingPass bp = new BoardingPass(emptySeat, pass, f);
                boardingPasses.put(pass, bp);
                pass.issueBoardingPass(f, bp);
                return "Boarding pass issued";
            }
        }
        return "Error trying to issue boarding pass";
    }
    
    public String getBoardingPass(String passportNo, String flightNo){
        Passenger pass = passengers.get(passportNo);
        
        if(pass != null){
            Flight f = flights.get(flightNo);
            
            if(f != null){
                BoardingPass bp = pass.getBoardingPass(f);
                return bp.toString();
            }
        }
        return "Error getting the boarding pass details";
    }
}
