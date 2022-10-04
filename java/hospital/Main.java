package test;

import java.sql.*;
import java.util.Scanner;

public class Main {


    private final static String INSERT_NEW = "insert into bolnoilists values (?,?,?,?,?)";

    private static DataBase db = new DataBase();

    public static void main(String[] args) throws SQLException {
        db.loading();
        menu();
    }

    private static void menu() throws SQLException{

        Scanner scan = new Scanner(System.in);
        mark:
        while (true) {
            System.out.println();
            System.out.println("1. Отделы");
            System.out.println("2. Больные");
            System.out.println("3. Врачи");
            System.out.println("4. Списки");
            System.out.println("5. Сохранение");
            System.out.println("0. Выход");
            int result = scan.nextInt();

            switch (result) {
                case 1:
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int a = scan.nextInt();
                    if (a == 1) {
                        db.addOtdel(db.newOtdel());
                    }
                    if (a == 2) {
                        db.showIdOtdel();db.deleteOtdel();
                    }
                    if (a == 3) {
                        db.showIdOtdel();db.changeOtdel();
                    }
                    break;
                case 2:
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int x = scan.nextInt();
                    if (x==1){
                        db.addBolnoi(db.newBolnoi());
                    }
                    if (x==2){
                        db.showIdBolnoi();db.deleteBolnoi();
                    }
                    if (x==3){
                        db.showIdBolnoi();db.changeBolnoi();
                    }
                    break;
                case 4:
                    System.out.println("1 Отделения 2 Больные 3 Врачи 4 Все вместе 5 По отдельности ");
                    int b = scan.nextInt();
                    if (b==1){
                        System.out.println("Название\t"+ "Количество врачей\t" + "Количество больных");
                        db.showOtdel();
                    }
                    if (b==2){
                        db.showBolnoi();
                    }
                    if (b==4){
                        db.showOtdel(); db.showVrach(); db.showBolnoi();
                    }
                    if (b==3){
                        db.showVrach();
                    }
                    if (b==5){
                        System.out.println("1 По отделению 2 Весь список по отделениям");
                        int s = scan.nextInt();
                        if (s==1){
                            db.showPoOtdel();
                        }
                        if (s==2){
                            db.showVsePoOtdel();
                        }
                    }
                    break ;
                case 3:
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int l = scan.nextInt();
                    if (l==1){
                        db.addVrach(db.newVrach());
                    }
                    if (l==2){
                        db.showIdVrach();db.deleteVrach();
                    }
                    if (l==3){
                        db.showIdVrach();db.changeVrach();
                    }
                    break;
                case 5:
                    System.out.println("Сохранение....");
                    db.save();



                    break;
                default:db.save();
                    break mark;
            }
        }

}
}

