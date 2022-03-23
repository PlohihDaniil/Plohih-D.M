package Plohih1;

public class Zadanie {
	public static void main(String[] args) {
		int[] mass = {1, 3, 5, 2, 7, 5, 9, 4, 8, 6};
		int min=mass[0];
		for (int i = 1; i < mass.length; i++) {
			if (mass[i] < min) {
				min=mass[i];
			}
		}
		for (int i=0;i<mass.length;i++) {
			System.out.print(mass[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < mass.length; i++) {
			mass[i]-=min;
		}
		for (int i=0;i<mass.length;i++) {
			System.out.print(mass[i] + "\t");
		}
		
	}
}
