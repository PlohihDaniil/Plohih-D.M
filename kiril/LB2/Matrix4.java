package LB2;

import java.util.Random;
import java.util.Scanner;

public class Matrix4 {
	public static void main(String[] args) {
		Random rand = new Random();
		
	Scanner in = new Scanner(System.in);
	
	int k=0,i,j,sum=0;
	
	System.out.println("Paramitri matrix n:");
	int n = in.nextInt();

	int[][] matr = new int [n][n];
	
	//ограничение рандомных чисел
			int min = -10;
			int max = 10;
			
	// заполнение матрицы
			for ( i = 0; i < n; i++) {
			    for ( j = 0; j < n; j++) {
			        matr[i][j]=new Random().nextInt(11) - 5;;
			    }
			}
			
	//вывод матрицы
			for ( i = 0; i < n; i++) {
			    for ( j = 0; j < n; j++) {
			        System.out.print(matr[i][j] + "\t");
			    }
			    System.out.println();
			}
	
			System.out.println();
			
			for ( i = 1, j = 1; i < n ; i++,j++) {
				if (matr[i-1][j] > 0) {
				sum += matr [i-1][j]; 
				k+=1;
				}
			}
			if (k==0) {
				System.out.println("Не найдено положительных чисел");
			}
			else {
			System.out.print(sum / k);
			}
			
			
			
			
			
	}
}
