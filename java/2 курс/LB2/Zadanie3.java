package Plohih3;
import java.util.Random;
import java.util.ArrayList;
public class Zadanie3 {
	public static void main(String[] args) {
		ArrayList <Integer> vec = new ArrayList<>();
		int n=5;
		int sum=0;
		int[][] mat= new int [n][n];
		
		for (int i=0;i<n;i++) {
			for (int j=0; j<n; j++ ) {
				mat[i][j] = new Random().nextInt(20)-10;
				System.out.print(mat[i][j]+"\t");
			}
			System.out.println();
		}
		
		for (int j=0; j<n; j++) {
			sum=0;
			for (int i=0; i<n; i++) {
				if (mat[i][j]>0) {
				sum+=mat[i][j];	
				}
			}
		vec.add(sum);
		}
		System.out.println();
		for (int i: vec) {
			System.out.print(i+"\t");
		}
		
		
		
		
		
		
	}
}
