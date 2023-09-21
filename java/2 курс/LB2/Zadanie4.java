package Plohih4;
import java.util.Random;
public class Zadanie4 {
		public static void main(String[] args) {
			int n=5;
			int sum=1;
			int[][] A= new int [n][n];
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				A[i][j] = new Random().nextInt(20)-10;
				System.out.print(A[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=n-2, j=0; j<n-1; i--, j++) {
			System.out.print(A[i][j]+"\t");
			if(A[i][j]<0) {
				sum*= A[i][j];
			}
		}
		System.out.println();
		System.out.print(sum);
	}
}
