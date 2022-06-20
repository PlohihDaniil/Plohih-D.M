package LB2;
import java.util.Random;
import java.util.Scanner;

public class Matrix3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int k,i,j,sum;
		System.out.println("Paramitri matrix h и n:");
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int [n][m];
		
		//ограничение рандомных чисел
				int min = 0;
				int max = 100;
				
		// заполнение матрицы
				for ( i = 0; i < n; i++) {
				    for ( j = 0; j < m; j++) {
				        matr[i][j]=new Random().nextInt(max - min);
				    }
				}
				
		//вывод матрицы
				for ( i = 0; i < n; i++) {
				    for ( j = 0; j < m; j++) {
				        System.out.print(matr[i][j] + "\t");
				    }
				    System.out.println();
				}
		
				System.out.println();
				
				for ( i =0 ; i<m; i++) {
					k = 0;
					sum = 1;
					for ( j=0;j<n;j++) {
						if ( matr[j][i] > 0) {
							k += 1;
							sum = sum * matr[j][i];
						}
						
					}
					System.out.println("Среднее геометрическое " + i + " столбца = " + Math.pow(sum, 1.0/k) );
				}
		}
	}

