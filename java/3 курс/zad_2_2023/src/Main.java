import Audi.AudiFactory;
import Bmw.BmwFactory;
import Interface.AutoFactory;
import Interface.Body;
import Interface.Engine;
import Interface.Wheels;
import Lada.LadaFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AutoFactory autoFactory = null;
        Scanner scanner = new Scanner(System.in);

        do{

            System.out.println("""
                
                Выберите завод
                1. Audi
                2. LADA
                3. BMW
                0. Выход
                """);

            switch (scanner.nextInt()){
                case 1 -> autoFactory = new AudiFactory();
                case 2 -> autoFactory = new LadaFactory();
                case 3 -> autoFactory = new BmwFactory();
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Такого завода не существует!!!");
            }

            Body body = autoFactory.getBody();
            Engine engine = autoFactory.getEngine();
            Wheels wheels = autoFactory.getWheels();

            System.out.println("Запуск завода...");

            body.create();
            wheels.create();
            engine.create();

        }while (true);

    }
}