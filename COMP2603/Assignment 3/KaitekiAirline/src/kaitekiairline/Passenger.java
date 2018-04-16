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
public class Passenger {
    String firstName = new String();
    String lastName = new String();
    String passportNo = new String();
    HashMap<Flight, BoardingPass> boardingPasses = new HashMap<>();
    
    public Passenger(String fName, String lName, String passNo){
        firstName = fName;
        lastName = lName;
        passportNo = passNo;
    }
    
    public String issueBoardingPass(Flight f, BoardingPass bp){
        boardingPasses.put(f, bp);
        return "Completed";
    }
    
    public BoardingPass getBoardingPass(Flight f){
        return boardingPasses.get(f);
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public String getName(){
        return firstName + " " + lastName;
    }
    
    public String getPassNo(){
        return passportNo;
    }
}
