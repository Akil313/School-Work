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
        
        Flight f2 = new Flight("AH1210", "MIA", "CAN");
        flights.put(f2.getNo(), f2);
    }
    
    public String addPassenger(String firstName, String lastName, String passportNo){
        Passenger pass = new Passenger(firstName, lastName, passportNo);
        
        if(passengers.containsKey(passportNo)){
            return "Passenger already exists!";
        }
        
        passengers.put(pass.getPassNo(), pass);
        
        return "Passenger successfully added";
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
        
        if(pass != null){
            name.add(pass.getFirstName());
            name.add(pass.getLastName());
            return name;
        }
        
        return null;
    }
    
    public String issueBoardingPass(String passportNo, String flightNo){
        Passenger pass = passengers.get(passportNo);
        Flight f = flights.get(flightNo);
        
        if(pass != null && f != null){
            String emptySeat = f.getEmptySeat();
            if(emptySeat != null){
                BoardingPass bp = new BoardingPass(f);
                bp.setSeatNo(emptySeat);
                boardingPasses.put(pass, bp);
                pass.issueBoardingPass(f, bp);
                f.assignSeat(bp.getSeatNo(), bp);
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
    
    public String getSeatMap(String flightNo){
        return flights.get(flightNo).getSeatMap();
    }
    
    public String updateSeat(String passportNo, String flightNo, String seatNo){
        Passenger pass = passengers.get(passportNo);
        Flight f = flights.get(flightNo);
        BoardingPass bp = pass.getBoardingPass(f);
            
        if(pass != null && f.validSeat(seatNo)){
            boolean valid = f.releaseSeat(bp.getSeatNo(), bp);
            
            if(valid == true){
                BoardingPass newPass = new BoardingPass(f);
                newPass.setSeatNo(seatNo);
                if(pass.replaceBoardingPass(f, bp, newPass) != false){
                    f.assignSeat(seatNo, newPass);
                    return "Successful";
                }
            }
            return "The seat is either taken or a valid boarding pass was not found for this flight.";
        }
        return "Seat does not exist";
    }
    
    public Flight getFlight(String flightNo){
        return flights.get(flightNo);
    }
    
    public Passenger getPassenger(String passportNo){
        return passengers.get(passportNo);
    }
}
