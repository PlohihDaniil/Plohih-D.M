



package LB4;

import java.util.Scanner;

public class Main {
	
	private static DataBaseCar myDB = new DataBaseCar();
	 
    public static void main(String[] args) {
    	
        menu();
        
    }
 
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Add Car");
            System.out.println("2. Pokaz vse");
            System.out.println("0. Exit");
            int result = scan.nextInt();
 
            switch (result) {
                case 1:
                	System.out.println("1 B/Y Car 2 Sport 3 SpecTex");
                	int a = scan.nextInt();
                	if (a == 1) {
                		myDB.addBY(myDB.newBY());
                	}
                    if (a == 2) {
                    	myDB.addSport(myDB.newSport());	
                    }
                    if (a == 3) {
                    	myDB.addSpecTex(myDB.newST());
                    }	
                    
                    break;
                case 2:
                	myDB.showBY();myDB.showSP();myDB.showST();
                    break;
              default:
                    break mark;
            }
        }
    }

}
