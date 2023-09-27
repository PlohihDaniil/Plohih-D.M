import Devices.Monitor;
import Devices.Plotter;
import Devices.Printer;
import Figures.Square;
import Figures.Triangle;
import Figures.Circle;
import Other.Figures;
import Other.Task;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {

            Triangle triangle = new Triangle();
            Circle circle = new Circle();
            Square square = new Square();


            Task task = null;

            System.out.println("""
                    
                    Выберите фигуру
                    1. Квадрат
                    2. Треугольник
                    3. Круг
                    """);

            Figures figures = null;

            switch (scanner.nextInt()){
                case 1 -> figures = square;
                case 2 -> figures = triangle;
                case 3 -> figures = circle;
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такой фигуры!!!");
            }


            System.out.println("""
                    
                    Выберите устройство вывода
                    1. Монитор
                    2. Принтер
                    3. Плоттер
                    0. Выход
                    """);
            switch (scanner.nextInt()){
                case 1 -> task = new Monitor(figures);
                case 2 -> task = new Printer(figures);
                case 3 -> task = new Plotter(figures);
                case 0 -> System.exit(0);
                default -> throw new RuntimeException("Нет такого устройства!!!");
            }
            task.conclusion();


        }while (true);
    }
}