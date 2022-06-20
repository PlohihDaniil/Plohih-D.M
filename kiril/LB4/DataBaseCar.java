package LB4;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class DataBaseCar extends Main {
	
	private List<Sport> sp = new ArrayList<>();
	private List<BY> by = new ArrayList<>();
	private List<SpecTex> st = new ArrayList<>();
	
    void addBY(BY bycar) {

    	by.add(bycar);

    }
	
	void addSport(Sport Sport) {

    	sp.add(Sport);

    }
    
    void addSpecTex(SpecTex SpecTex) {
    	
    	st.add(SpecTex);
    	
    }

    Sport newSport() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute name car: ");
        String nameCar = scan.next();
        System.out.print("Vvedute god vupyska: ");
        int god = scan.nextInt();
        System.out.print("Vvedute sell: ");
        int sell = scan.nextInt();
        System.out.print("Vvedute complex: ");
        String complex = scan.next();
        System.out.print("Vvedute strana: ");
        String strana = scan.next(); 
        System.out.print("Vvedute data sell: ");
        int dataSell = scan.nextInt();
        System.out.print("Vvedute name men: ");
        String nameMen = scan.next();
        
        System.out.print("Vvedute kolvo sec do nabora speed: ");
        int sec = scan.nextInt();
        
        System.out.println("Vvedute obem dvug: ");
        int  obDvug = scan.nextInt();
        
        System.out.println("Vvedute power: ");
        int power = scan.nextInt();
        
        Sport h = new Sport( nameCar,  god, sell,  complex, strana, 
    			 dataSell,  nameMen, sec,  obDvug,  power);
       System.out.println(h);
       return h;
    	}
    
    BY newBY() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute name car: ");
        String nameCar = scan.next();
        System.out.print("Vvedute god vupyska: ");
        int god = scan.nextInt();
        System.out.print("Vvedute sell: ");
        int sell = scan.nextInt();
        System.out.print("Vvedute complex: ");
        String complex = scan.next();
        System.out.print("Vvedute strana: ");
        String strana = scan.next(); 
        System.out.print("Vvedute data sell: ");
        int dataSell = scan.nextInt();
        System.out.print("Vvedute name men: ");
        String nameMen = scan.next();
        System.out.print("Vvedute stepen save: ");
        int stepSave = scan.nextInt();
        
        System.out.println("Vvedute FIO: ");
        String  FIO = scan.next();
        
        System.out.println("Vvedute probeg: ");
        int probeg = scan.nextInt();
        BY h = new BY( nameCar,  god, sell,  complex, strana, 
    			 dataSell,  nameMen, stepSave,  FIO,  probeg);
       System.out.println(h);
       return h;
    }
 
    SpecTex newST() {
    	Scanner scan = new Scanner(System.in);
        System.out.println("Vvedute name car: ");
        String nameCar = scan.next();
        System.out.print("Vvedute god vupyska: ");
        int god = scan.nextInt();
        System.out.print("Vvedute sell: ");
        int sell = scan.nextInt();
        System.out.print("Vvedute complex: ");
        String complex = scan.next();
        System.out.print("Vvedute strana: ");
        String strana = scan.next(); 
        System.out.print("Vvedute data sell: ");
        int dataSell = scan.nextInt();
        System.out.print("Vvedute name men: ");
        String nameMen = scan.next();
       
        System.out.print("Vvedute vud texnuku: ");
        String vud = scan.next();
        
        System.out.println("Vvedute Massa: ");
        int  massa = scan.nextInt();
        
        System.out.println("Vvedute Gabarutu: ");
        int gabarut = scan.nextInt();
        
        SpecTex h = new SpecTex( nameCar,  god, sell,  complex, strana, 
    			 dataSell,  nameMen, vud,  massa,  gabarut);
       System.out.println(h);
       return h;
    }
    
    void showSP() {
        sp.forEach(System.out::println);
    }
    
    void showBY() {
    	by.forEach(System.out::println);
    }
    
    void showST() {
    	st.forEach(System.out::println);
    }

}
