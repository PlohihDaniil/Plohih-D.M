package Plohih1;

public class Zadanie1 {
	public static void main(String[] args) {
		int[] mass= {23,36,15,11};
		int x=mass[0];
		int sum=0;
		for (int i=1; i<mass.length; i++) {
			if (x<mass[i]) {
				sum +=1;
			}
			x=mass[i];
		}
		System.out.println(sum);
	}
}
