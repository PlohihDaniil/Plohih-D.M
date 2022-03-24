package Plohih2;
import java.util.Random;
public class Zadanie2 {
	public static void main(String[] args) {
		int n=10;
		
		int[] c= new int [n];
		int[] v= new int [n];
		int sum=0;
		//заполнение массива
		for(int i=0; i<n;i++) {
			c[i]=new Random().nextInt(20)-10;
		}
		//перемещение из массива c в v
		for(int i=0; i<n; i++) {
			if(c[i]!=0) {
				v[sum]=c[i];
				sum+=1;
			}
		}
		
		int[] x= new int[sum];
		for(int i=0; i<sum; i++) {
			x[i]=v[i];
			
		}
		//sort
		for (int t=0;t<n*2;t++) {
			for(int i=0, j=1; j<x.length; i++, j++) {
				int min =x[i];
				if(min>x[j]) {
					x[i]=x[j];
					x[j]=min;
				}
			}
		}
		
		//вывод
		
		for (int i:c) {
			System.out.print(i+"\t");
		}System.out.println();
		for (int i:v) {
			System.out.print(i+"\t");
		}
		System.out.println();
		for (int i:x) {
			System.out.print(i+"\t");
		}
	}
}
