package Plohih2;

public class Zadanie {
	public static void main(String[] args) {
		int[] mass = {1, 3, 5, 10, 7, 5, 9, 4, 8, 6};
		int max = mass[0];
		int maxN = 0;
		//����� �������
		for (int i=0;i<mass.length;i++) {
			System.out.print(mass[i] + "\t");
		}
		//���������� ���������
		for (int i = 0; i < mass.length; i++) {
			if (max<mass[i]) {
				max = mass[i];
				maxN = i;
			}
		}
		//����� ��������� � ��� ������
		System.out.println();
		System.out.println("Max znashenie= " + max);
		System.out.println("Porydkoviy �= " + maxN);
		//����������
		for(int i = maxN+1; i<mass.length-1; i++) {
	         for (int j = i+1; j<mass.length; j++) {
	            if(mass[i] > mass[j]) {
	               int temp = mass[i];
	               mass[i] = mass[j];
	               mass[j] = temp;
	            }
	         }
		}
		System.out.println();
		//����� �������
		for (int i=0;i<mass.length;i++) {
			System.out.print(mass[i] + "\t");
		}
		
		
	}
}
