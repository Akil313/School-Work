/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kaitekiairline;

/**
 *
 * @author Akil313
 */
public class BoardingPass {
    String seatNo = new String();
    Passenger p;
    Flight f;
    
    public BoardingPass(Flight f){
       this.f = f;
    }
    
    public String getSeatNo(){
        return seatNo;
    }
    
    public boolean setSeatNo(String seatNo){
        this.seatNo = seatNo;
        return true;
    }
    
    public void addPassenger(Passenger p){
        this.p = p;
    }
    
    @Override
    public String toString(){
        return "Passenger: " + p.getName() + "\nFlight: " + f.getNo() + "\nLeaving from: " + f.getLeaving()
                + "\nDestined to: " + f.getDestination() + "\nSeat No.: " + getSeatNo();
    }
    
    public boolean equals(BoardingPass pass){
        if(pass.getSeatNo().equals(seatNo)){
            return true;
        }
        return false;
    }
}
