package LB1;

public class Word3 {
	public static void main(String[] args) {
		int N=args.length;
		if (N==2) {
		System.out.println("��������: " + args[0] + ", " + args[1] + ".");
		int a = Integer.parseInt (args[0]);
		int b = Integer.parseInt (args[1]);
		System.out.println("�����= "+ (a+b));
		}
		else{
			System.out.println("�� ������ ���������� ����������");
		}
}}
