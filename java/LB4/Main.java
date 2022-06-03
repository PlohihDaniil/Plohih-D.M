/*
 * Describe the properties, constructor, getters/setters methods, override 
 * the toString() method to output complete information about the object in formatted form:
 * id_studenta
 * fam
 * name
 * group
 * kafedra
 * disciplina
 * mark
 * nameprepod
 */



package Spusok;

import java.util.Scanner;

public class Main {
	
	private static DataBaseZO myDB = new DataBaseZO();
	 
    public static void main(String[] args) {
    	
        menu();
        
    }
 
    private static void menu() {
        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println("1. Add tovar");
            System.out.println("2. Pokaz vse");
            System.out.println("0. Exit");
            int result = scan.nextInt();
 
            switch (result) {
                case 1:
                	System.out.println("1 Ugryshku 2 Fruits 3 Gabaritnui tovar");
                	int a = scan.nextInt();
                	if (a == 1) {
                		myDB.addUgryshka(myDB.newUgryshka());	
                	}
                    if (a == 2) {
                    	myDB.addFruits(myDB.newFR());
                    }
                    if (a == 3) {
                    	myDB.addGabaritnuiTovar(myDB.newGT());
                    }	
                    
                    break;
                case 2:
                	myDB.showOC();myDB.showZO();myDB.showGT();
                    break;
                default:
                    break mark;
            }
        }
    }

}
