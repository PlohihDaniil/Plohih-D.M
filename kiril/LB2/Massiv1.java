package LB2;
import java.util.Scanner;
import java.util.Random;

public class Massiv1 {
	
	public static void main (String args[]) {
		Random rand = new Random();
		
	    int sum=0, n, arr[];
	    Scanner in = new Scanner(System.in);
	    System.out.println("¬ведите размер массива");
	    n = in.nextInt();

	    arr = new int [n];
	    
	    for ( int i = 0 ; i < n ; i++) {
	        arr[i] = rand.nextInt(11) -5;
	    }
	    
	    for (int i = 0 ; i < n-1 ; i++ ) {
	    	
	    	if  (arr[i] >= 0  &&  arr[i+1] < 0) {
	    		sum += 1;
	    	}
	    	
	    	if  (arr[i] < 0  &&  arr[i+1] >= 0) {
	    		sum += 1;
	    	}
	    }
	    
	    for ( int i: arr) {
	        System.out.print( i + " " );
	    }
	    
	    System.out.println("\n" + "Kolvo uzmeneny znaka= " + sum);
	}
}
