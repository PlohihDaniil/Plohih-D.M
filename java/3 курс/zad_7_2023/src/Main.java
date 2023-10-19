import java.util.Scanner;

public class Main {
    static UserBuilder builder = new Person();
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        do {
            System.out.println("""
                ---MENU---
                1. Создать User
                0. Exit
                """);

            switch (scanner.nextInt()){
                case 1 -> create();
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такого выбора");
            }



        }while (true);
    }
    public static void create(){
        builder.creatUser();
        System.out.println("Введите имя");
        builder.buildName(scanner.next());
        System.out.println("Введите mail");
        builder.buildMail(scanner.next());
        System.out.println("Введите возраст");
        builder.buildAge(scanner.nextInt());

        User user = builder.getUser();

        System.out.println(user);

    }
}