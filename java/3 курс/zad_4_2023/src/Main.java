import Adapter.AdapterSD;
import Adapter.AdapterUSB;
import Interface.Actions;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Actions actions = null;

        do {
            System.out.println("""
                
                Выберите устройство:
                1. USB
                2. SD
                0. Выход
                """);

            switch (scanner.nextInt()){
                case 1 -> actions = new AdapterUSB();
                case 2 -> actions = new AdapterSD();
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такого устройства!!!");
            }

            actions.read();
            actions.write();

        }while (true);
    }
}