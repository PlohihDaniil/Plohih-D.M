package Spusok;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class DataBaseZO extends Main {
	
	private List<Ugryshka> ug = new ArrayList<>();
	private List<Fruits> fr = new ArrayList<>();
	private List<GabaritnuiTovar> gt = new ArrayList<>();
	
    void addUgryshka(Ugryshka Ugryshka) {

    	ug.add(Ugryshka);

    }
    
    void addFruits(Fruits Fruits) {

    	fr.add(Fruits);

    }
    
    void addGabaritnuiTovar(GabaritnuiTovar GabaritnuiTovar) {
    	
    	gt.add(GabaritnuiTovar);
    	
    }

    Ugryshka newUgryshka() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute nazvanie otdela: ");
        String nameotdela = scan.next();
        System.out.print("Vvedute nazvanie tovara: ");
        String name = scan.next();
        System.out.print("Vvedute strany prouzvoduteli: ");
        String cuntry = scan.next();
        System.out.print("Vvedute roznuchnai cena: ");
        int retailPrice = scan.nextInt();
        System.out.print("Vvedute postavchuk: ");
        String namesource = scan.next();
        System.out.print("Vvedute vozrastnai group: ");
        int vozrastgroup = scan.nextInt();
        System.out.print("vvedute typ: ");
        String typ = scan.next();
        
        Ugryshka h = new Ugryshka(  nameotdela ,  name,  cuntry,  retailPrice,
        		 namesource,  vozrastgroup,  typ);
        System.out.println(h);
        return h;
    	}
    
    Fruits newFR() {
    	 Scanner scan = new Scanner(System.in);
         System.out.println("Vvedute nazvanie otdela: ");
         String nameotdela = scan.next();
         System.out.print("Vvedute nazvanie tovara: ");
         String name = scan.next();
         System.out.print("Vvedute strany prouzvoduteli: ");
         String cuntry = scan.next();
         System.out.print("Vvedute roznuchnai cena: ");
         int retailPrice = scan.nextInt();
         System.out.print("Vvedute postavchuk: ");
         String namesource = scan.next();
         System.out.print("Vvedute max time xranenuy: ");
         int maxtime = scan.nextInt();
         System.out.print("vvedute temperatyry xranenuy: ");
         int temperatyra = scan.nextInt();
         
        Fruits h = new Fruits(  nameotdela,    name,  cuntry, 
        		 retailPrice,  namesource,  maxtime,  temperatyra);
        System.out.println(h);
        return h;
    }
 
    GabaritnuiTovar newGT() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute nazvanie otdela: ");
        String nameotdela = scan.next();
        System.out.print("Vvedute nazvanie tovara: ");
        String name = scan.next();
        System.out.print("Vvedute strany prouzvoduteli: ");
        String cuntry = scan.next();
        System.out.print("Vvedute roznuchnai cena: ");
        int retailPrice = scan.nextInt();
        System.out.print("Vvedute postavchuk: ");
        String namesource = scan.next();
        System.out.print("Vvedute vusaty: ");
        int h = scan.nextInt();
        System.out.print("Vvedute shuruny: ");
        int x = scan.nextInt();
        System.out.println("Vvedute dluny: ");
        int y = scan.nextInt();
        
        GabaritnuiTovar b = new GabaritnuiTovar(  nameotdela,  name,  cuntry,
    			 retailPrice,  namesource,  h,  x,  y);
        System.out.println(h);
        return b;
    }
    
    void showZO() {
        ug.forEach(System.out::println);
    }
    
    void showOC() {
    	fr.forEach(System.out::println);
    }
    
    void showGT() {
    	gt.forEach(System.out::println);
    }


}
