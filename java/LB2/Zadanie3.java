package Plohih3;
import java.util.Scanner;//��� ����� ������
import java.util.Random;
import java.util.ArrayList;
public class Zadanie {
	public static void main(String[] args) {
		ArrayList <Integer> vec = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		System.out.println("Paramitri matrix n � m:");
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matr = new int [n][m];
		
		//����������� ��������� �����
				int min = 0;
				int max = 100;
				
		// ���������� �������
				for (int i = 0; i < n; i++) {
				    for (int j = 0; j < m; j++) {
				        matr[i][j]=new Random().nextInt(max - min);
				    }
				}
				
		//����� �������
				for (int i = 0; i < n; i++) {
				    for (int j = 0; j < m; j++) {
				        System.out.print(matr[i][j] + "\t");
				    }
				    System.out.println();
				}
		//���������� ������������ �������� � �����
				for (int j = 0; j < m; j++) {
					int nn = matr[0][j];
				    for (int i = 0; i < n; i++) {
				    	if ( matr[i][j] < nn ) {
				    		nn=matr[i][j];
				    	}
				    }
				vec.add(nn);
					for (int i = 0; i < n; i++) {
						matr[i][j]*=nn;
					}
				}
		//����� �������
				System.out.println();
						for (int i = 0; i < n; i++) {
						    for (int j = 0; j < m; j++) {
						        System.out.print(matr[i][j] + "\t");
						    }
						    System.out.println();
						}
				System.out.println();

				for (int i:vec) {
				System.out.print(i + "\t");
				}
				
				in.close();	
		
		
	}
}
