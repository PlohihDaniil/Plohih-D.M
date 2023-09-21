import Factory.BySuitFactoryCards;
import Factory.FactoryCars;
import Factory.FullFactoryCards;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        FactoryCars factoryCars;

        int size;
        int suit = 0;

        System.out.println("""
                        Выберите
                        1. 24 карты
                        2. 36 карты
                        3. 52 карты
                        """);

        switch (scanner.nextInt()){
            case 1 -> size = 24;
            case 2 -> size = 36;
            case 3 -> size = 52;
            default -> throw new RuntimeException("Нет такой команды!!!");
        }

        System.out.println("""
                        Выберите режим
                        1. По масти
                        2. Полный рандом
                        """);

        int mode = scanner.nextInt();
        if (mode == 1){
            System.out.println("""
                        1. Бубей
                        2. Пик
                        3. Червей
                        4. Крестей
                        """);
            suit = scanner.nextInt();

        }
        factoryCars = start(mode);
        factoryCars.print(size,suit);

    }
    private static FactoryCars start( int mode){
        if (mode == 1){
            return new BySuitFactoryCards();
        }else if (mode == 2){
            return new FullFactoryCards();
        }else {
            throw new RuntimeException("Нет такой команды!!!");
        }
    }


}