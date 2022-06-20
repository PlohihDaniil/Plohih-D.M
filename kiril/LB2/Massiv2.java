package LB2;
import java.util.Scanner;
import java.util.Random;

public class Massiv2 {
	public static void main (String args[]) {
		int n=10;
		int sum=0;
		
		int[] x= new int [n];
		int[] v= new int [n];
		
		//заполнение массива и вывод
		for(int i=0; i<n;i++) {
			x[i]=new Random().nextInt(20)-10;
		}
		
		for (int i:x) {
			System.out.print( i + " " );
		}
		
		//заполнение временного массива
		for (int i=0; i<n; i++) {
			if ( x[i] > 3 ) {
				v[sum]=x[i];
				sum+=1;
			}
		}
		
		System.out.println();
		
		//delete 0
		int[] y= new int[sum];
		
		for(int i=0; i<sum; i++) {
			y[i]=v[i];
		}
		
		//sort
		for (int t=0;t<n*2;t++) {
			for(int i=0, j=1; j<y.length; i++, j++) {
				int min =y[i];
				if(min>y[j]) {
					y[i]=y[j];
					y[j]=min;
				}
			}
		}
		
		for (int i:y) {
			System.out.print( i + " " );
		}
		
		
		
		
		
	}
}
