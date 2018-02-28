// This class contains is for the purpose of creating a user interface for the user to
// access the different functions to either add, modify or display information on the packages and flights

import java.util.Scanner;
public class PaketzustellungConsole{
    private Scanner sc = new Scanner(System.in);
    private PaketzustellungSystem sys = new PaketzustellungSystem();
    
    public PaketzustellungConsole(){
        
    }
    
    public int runMenu(){
        System.out.println("1) Add a new package \n" +
                           "2) Add a new flight \n" +
                           "3) Display packages by owner name \n" +
                           "4) Display packages by ID \n" +
                           "5) Update a flight's status \n" + 
                           "6) Display information on all packages \n" +
                           "7) Display information on all flights \n" +
                           "8) Exit system");
        
        return sc.nextInt();
    }
    
    //Based on the passed choice from the user, this constructor initializes the different 
    //functions available
    public void choices(int choice){
        String dest;
        String owner;
        double weight;
        String fNum;
        int pID;
        char code;
        boolean check;
        
        sc.nextLine();
        
        switch(choice){
            case 1: System.out.println("Input package destination: ");
                    dest = sc.nextLine();
                    
                    System.out.println("Input package owner: ");
                    owner = sc.nextLine();
                    
                    System.out.println("Input package weight: ");
                    weight = sc.nextDouble();
                    
                    check = sys.addPackage(dest, owner, weight);
                    if(check){
                        System.out.println("Package was added.\n");
                    }else{
                        System.out.println("Package was not added.\n");
                    }
                    break;
                    
            case 2: System.out.println("Input flight number: ");
                    fNum = sc.nextLine();
                    
                    System.out.println("Input flight destination: ");
                    dest = sc.nextLine();
                    
                    check = sys.addFlight(fNum, dest);
                    if(check){
                        System.out.println("Flight was added.\n");
                    }else{
                        System.out.println("Flight was not added.\n");
                    }
                    break;
                    
            case 3: System.out.println("Input owner name: ");
                    owner = sc.nextLine();
                    
                    System.out.println(sys.listPackages(owner));
                    break;
                    
            case 4: System.out.println("Input package ID: ");
                    pID = sc.nextInt();
                    
                    System.out.println(sys.listPackage(pID));
                    break;
                    
            case 5: System.out.println("Input flight number: ");
                    fNum = sc.nextLine();
                    
                    System.out.println("Input update code (A = arrived, D = delayed, O = on time): ");
                    code = sc.next().charAt(0);
                    
                    sys.updateFlightStatus(fNum, code);
                    break;
            
            case 6: System.out.println(sys.listPackages());
                    break;
            
            case 7: System.out.println(sys.listFlights());
                    break;
                    
            case 8: System.exit(0);
            
            default: System.out.println("Incorrect choice!\n");
                     break;
        }
    }
    
    public static void main(String[] args){
        PaketzustellungConsole con = new PaketzustellungConsole();
        
        int choice;
        System.out.println("Welcome to Paketzustellung Service\n\n");
        
        while(true){
            choice = con.runMenu();
            con.choices(choice);
        }
    }
}