import City.*;
import Interface.Observed;
import Interface.Observer;
import User.Subscriber;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Observer first = new Subscriber("Ivan");
        Observer second = new Subscriber("Nasty");

        Observed moscow = new Moscow();
        Observed voronezh = new Voronezh();

        moscow.addObserver(first);
        voronezh.addObserver(second);

        do {

            System.out.println("""
                    ---MENU---
                    1. Moscow
                    2. Voronezh
                    0. Exit
                    """);
            switch (scanner.nextInt()){
                case 1 -> weather(moscow);
                case 2 -> weather(voronezh);
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такой позиции!!!");
            }

        }while (true);
    }
    public static void weather(Observed city){
        System.out.println("""
                
                1. Добавить прогноз
                2. Удалить прогноз
                0. Exit
                
                """);
        switch (scanner.nextInt()){
            case 1 -> {
                System.out.println("Какой прогноз -> ");
                city.addWeather(scanner.next());
            }
            case 2 ->{
                System.out.println("Какой прогноз -> ");
                city.removeWeather(scanner.next());
            }
            case 0 -> System.exit(0);
            default -> {throw new RuntimeException("Нет такой позиции!!!");
            }
        }
    }
}