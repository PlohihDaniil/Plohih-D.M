
public class hello4 {
	public static void main(String[] args) {
		String a,b;
		a="admin";
		b="1234";
		if (a.equalsIgnoreCase(args[0]) && b.equalsIgnoreCase(args[1])) {
			System.out.println("Вас узнали. Добро пожаловать.");
		}
		else {
			System.out.println("Логин и пароль не распознаны. Доступ запрещен.");
		}
}}
