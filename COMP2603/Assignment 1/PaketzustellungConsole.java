import java.util.*;

public class PaketzustellungConsole
{
    private PaketzustellungSystem Hello;
    private static PaketzustellungConsole Bye;
    public PaketzustellungConsole()
    {
        Hello = new PaketzustellungSystem();
    }

    public static void main(String[] args){
        Bye = new PaketzustellungConsole();
        
        while(true){
            Scanner scans = new Scanner(System.in);
            System.out.println("1: Add a new Package to the System ");
            System.out.println("2: Add a new Flight to the system");
            System.out.println("3: Display Packages by owner name");
            System.out.println("4: Display Package's details by ID");
            System.out.println("5: Update a Flight's status");
            System.out.println("6: Display information on all Packages in the system");
            System.out.println("7: Display information on all Flights in the system");
            System.out.println("8: Exit");
            
            int num = scans.nextInt();
            String menu = new String();
            switch(num){
                case 1: menu=Bye.addPackage();
                break;
                case 2: menu=Bye.addFlight();
                break;
                case 3: menu= Bye.displayPackages();
                break;
                case 4: menu= Bye.displayPackage();
                break;
                case 5: menu = Bye.updateFlightStatus();
                break;
                case 6: menu= Bye.displayTotalPackages();
                break;
                case 7: menu= Bye.displayTotalFlights();
                break;
                case 8: break;
            }
            System.out.println(menu);
        }
    }
    
    public boolean isLetter (char ch){
        if(ch >= 'A' || ch <= 'Z'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isNum (char num){
        if(num >='0' || num <= '9'){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean fNumValid(String fNum){
        if(fNum.length()==5){
        if(isLetter(fNum.charAt(0)) && isLetter(fNum.charAt(1)) && isNum(fNum.charAt(2)) && isNum(fNum.charAt(3)) && isNum(fNum.charAt(4))){
            return true;
        }
    }
    return false;
    }
    
    public String addPackage(){
        Scanner word = new Scanner(System.in);
        System.out.println("Enter the destination: ");
        String destination = word.nextLine();
        System.out.println("Enter your name: ");
        String owner = word.nextLine();
        System.out.println("Enter the weight of your package: ");
        double weight = word.nextDouble();
        
        System.out.println("1" + destination + owner + weight);
        
        boolean test = Hello.addPackage(destination, owner, weight);
        
        if(test == true){
            return "Package was added.";
        }
        else{
            return "Package was not added.";
        }
    }
    
    public String addFlight(){
        Scanner text = new Scanner(System.in);
        System.out.println("Enter your flight number: ");
        String num = text.nextLine();
        if(!fNumValid(num) && num.length()!=4){
            System.out.println("Invalid flight number!");
            System.out.println("Enter your flight number:");
            num = text.nextLine();
        }
        System.out.println("Enter your destination: ");
        String dest = text.nextLine();
        
        System.out.println(num + dest);
        
        boolean test2 = Hello.addFlight(num, dest);
        
        if(test2 == true){
            return "Flight was successfully added.";
        }
        else{
            return "Flight was unsuccessfully added.";
        }
    }
    
    public String displayPackages(){
        Scanner word2 = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String owner = word2.nextLine();
        
        String list = Hello.listPackages(owner);
        
        return list;
    }
    
    public String displayPackage(){
        Scanner text2 = new Scanner(System.in);
        System.out.println("Enter the package's ID: ");
        int ID = text2.nextInt();
        
        String num = Hello.listPackage(ID);
        
        return num;
    }
    
    public String updateFlightStatus(){
        Scanner word3 = new Scanner(System.in);
        System.out.println("Enter your flight number: ");
        String fNum = word3.nextLine();
        while(!fNumValid(fNum)){
            System.out.println("Invalid flight number!");
            System.out.println("Enter your flight number:");
            fNum = word3.nextLine();
        }
        System.out.println("Enter the status code: ");
        char code = word3.next().charAt(0);
        
        String update = Hello.updateFlightStatus(fNum, code);
        return update;
    }
    
    public String displayTotalPackages(){
        String display = Hello.listPackages();
        return display;
    }
    
    public String displayTotalFlights(){
        String display = Hello.listFlights();
        return display;
    }
}
