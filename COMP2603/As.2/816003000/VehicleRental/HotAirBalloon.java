
/**
 * Write a description of class HotAirBalloon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class HotAirBalloon extends Aircraft 
{
    int minAgeToOperate = 14;
    
    public HotAirBalloon(String regNo, String type, double rate){
        super(regNo, type, rate);
    }
    
    public boolean canBeOperated(VehicleLicense vl){
        if(!vl.isExpired() && vl.getLicenseType().contains("PILOT LICENSE") && vl.getLicenseHolderAge() >= minAgeToOperate){
            return true;
        }
        return false;
    }
    
    public String getLicenseError(VehicleLicense vl){
        String s = new String();
        if(vl.isExpired()){
            s = "License expired";
        }else
        if(vl.getLicenseType().equals("HotAirBalloon")){
            s = "Incorrect license to fly a Hot Air Balloon";
        }else{
            s = "Too young to operate a HotAirBalloon: " + vl.getLicenseHolderAge();
        }
        return s;
    }
    
    
}
