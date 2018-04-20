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
public class Flight {
    
    String flightNo;
    String destination;
    String origin;
    HashMap <String, BoardingPass> seats = new HashMap <>();
    Collection <String> validSeatNos = new ArrayList <>();
    
    public Flight(String flightNo, String destination, String origin){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
        populateValidSeats(1, 20);
    }
    
    public boolean validSeat(String seatNo){
        
        return validSeatNos.contains(seatNo);
    }
    
    public String getEmptySeat(){
        Random r = new Random();
//        int firstLet = (int) 'A';
//        int lastLet = (int) 'Z';
        String alphabet = "ABC";
        String seatNo = new String();
        
        if(seats.size() <= 60){
            boolean empty = false;
            
            while(empty == false){
                
                String seatInt = Integer.toString(r.nextInt(20) + 1);
                char seatLet = alphabet.charAt(r.nextInt(alphabet.length()));
                seatNo = seatInt + seatLet;
                
                if(seats.get(seatNo) == null){
                    empty = true;
                    return seatNo;
                }
            }
        }

        return null;
    }
    
    public boolean releaseSeat(String seatNo, BoardingPass bp){
        
        if(validSeat(seatNo) == false){
            return false;
        }
        
        if(seats.get(seatNo) != null){
            return false;
        }

        if(seats.get(seatNo) != null){
            seats.remove(seatNo);
            return true;
        }
        
    return false;   
    }
    
    public boolean assignSeat(BoardingPass bp){
        String tempSeatNo = getEmptySeat();
        
        if(tempSeatNo != null){
            bp.setSeatNo(tempSeatNo);
            seats.put(tempSeatNo, bp);
            return true;
        }
        return false;
    }
    
    public boolean assignSeat(String seatNo, BoardingPass bp){
        if(validSeat(seatNo) == false){
            return false;
        }
        
        if(seats.get(seatNo) == null){
            seats.put(seatNo, bp);
            return true;
        }
        return false;
    }
    
    public String getSeatMap(){
        String seatMap = "\tA\tB\tC\n";
        String seatLets = "ABC";
        String seatNo = new String();
        
        for(int x=1; x<=20; x++){
            seatMap = seatMap + x + "\t";
            
            //Processing the current number(x) with the seat letter A
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'A';
            
            if(seats.get(seatNo) == null){
                seatMap = seatMap + '-';
            }else{
                seatMap = seatMap + 'x';
            }
            seatMap = seatMap + "\t";
            
            //Processing the current number(x) with the seat letter B
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'B';
            
            if(seats.get(seatNo) == null){
                seatMap = seatMap + '-';
            }else{
                seatMap = seatMap + 'x';
            }
            seatMap = seatMap + "\t";
            
            //Processing the current number(x) with the seat letter C
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'C';
            
            if(seats.get(seatNo) == null){
                seatMap = seatMap + '-';
            }else{
                seatMap = seatMap + 'x';
            }
            seatMap = seatMap + "\t";
            
            seatMap = seatMap + "\n";
        }
        
        return seatMap;
    }
    
    public String getNo(){
        return flightNo;
    }
    
    public String getLeaving(){
        return origin;
    }
    
    public String getDestination(){
        return destination;
    }
    
    public String toString(){
        return seats.toString();
    }
    
    private void populateValidSeats(int min, int max){
        String seatNo = new String();
        
        for(int x=min; x<=max; x++){
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'A';
            validSeatNos.add(seatNo);
            
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'B';
            validSeatNos.add(seatNo);
            
            if(x > 0 && x < 10){
                seatNo = Character.toString((char)(x + (int)'0'));
            }else{
                seatNo = String.valueOf(x);
            }
            seatNo = seatNo + 'C';
            validSeatNos.add(seatNo);
        }
    }
}
