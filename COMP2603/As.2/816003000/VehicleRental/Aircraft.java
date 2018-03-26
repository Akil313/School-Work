
/**
 * Write a description of class Aircraft here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Aircraft extends Vehicle
{
    int minAgeToOperate = 17;
    int minHrsFlightTime = 0;
    
    public Aircraft(String regNo, String type, double rate){
        super(regNo, type, rate);
    }

    public int getMinAgeToOperate(){
        return minAgeToOperate;
    }
    
    public int getMinHrsFlightTime(){
        return minHrsFlightTime;
    }
}
