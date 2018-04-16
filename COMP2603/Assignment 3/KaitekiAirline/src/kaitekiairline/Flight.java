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
    
    public Flight(String flightNo, String destination, String origin){
        this.flightNo = flightNo;
        this.destination = destination;
        this.origin = origin;
    }
    
    private boolean validSeat(String seatNo){
        if(seatNo.length() == 2){
            if(seatNo.charAt(0) - '0' < 1){
                return false;
            }
        }else
        if(seatNo.length() == 3){
            if( Integer.parseInt(seatNo.substring(0, 2)) < 10 || Integer.parseInt(seatNo.substring(0, 2)) > 20){
                return false;
            }
        }else{
            return false;
        }
        char seatLet = seatNo.charAt(seatNo.length()-1);
        
        if(seatLet != 'A' && seatLet != 'B' && seatLet != 'C'){
            return false;
        }
        
        return true;
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
            
//                for(BoardingPass pass : seats){
//                    if(pass.getSeatNo().equals(seatNo)){
//                        found = true;
//                        break;
//                    }
//                }

        return null;
    }
    
    public boolean releaseSeat(String seatNo, BoardingPass bp){
        
        if(validSeat(seatNo) == false){
            return false;
        }
        
//        if(!seatNo.equals(bp.getSeatNo())){
//            return false;
//        }
        
//        for(BoardingPass pass : seats){
//            if(pass.getSeatNo().equals(seatNo)){
//                valid = true;
//                break;
//            }
//        }
//        
//        if(valid == false){
//            return false;
//        }

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
            System.out.print(seatNo);
            
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
            System.out.print(seatNo);
            
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
            System.out.print(seatNo);
            
            
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
}
