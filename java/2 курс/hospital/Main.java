package test;

import java.sql.*;
import java.util.Scanner;

public class Main {
//
//
//    private final static String INSERT_NEW = "insert into bolnoilists values (?,?,?,?,?)";

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
            System.out.println("3. Мед персонал");
            System.out.println("4. Оборудование");
            System.out.println("5. Кабинеты");
            System.out.println("6. Списки");
            System.out.println("7. Сохранение");
            System.out.println("0. Выход");
            int result = scan.nextInt();

            switch (result) {
                case 1:
                    //Отделения
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
                    else{break ;}
                    break;
                case 2:
                    //Больные
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
                    else{break ;}
                    break;
                case 3:
                    //Мед Персонал
                    System.out.println("1. Врачи 2. Мед сестры");
                    int k = scan.nextInt();
                    if (k==1){
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
                        else{break ;}
                        }
                    if (k==2){





                    }
                    else {break ;}
                    break;
                case 4:
                    //Оборудование
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать");
                    int q= scan.nextInt();
                    if (q==1){
                        db.addOb(db.newOb());
                    }
                    if (q==2){
                        db.showIdOb();db.deleteOb();
                    }
                    if (q==3){
                        db.showIdOb();db.changeOb();
                    }
                    else{break ;}
                    break ;
                case 5:
                    //Кабинет
                    System.out.println("1 Добавить 2 Удалить 3 Редактировать 4 Добавить оборудование 5 Удалить оборудование");
                    int h= scan.nextInt();
                    if(h==1){
                        db.addKab(db.newKab());
                    }
                    if(h==2){
                        db.showKab();db.deleteKab();
                    }
                    if(h==3){
                        db.showKab();db.changeKab();
                    }
                    if(h==4){
                        db.addObVKab();
                    }
                    if (h==5){
                        db.deleteObVKab();
                    }
                    break ;
                case 6:
                    //Список
                    System.out.println("1 Отделения 2 Больные 3 Врачи 4 Оборудования 5 Кабинеты 6 Все вместе 7 По отдельности ");
                    int b = scan.nextInt();

                    if (b==1){
                        System.out.println("Название\t"+ "Количество врачей\t" + "Количество больных");
                        db.showOtdel();
                    }

                    if (b==2){
                        db.showBolnoi();
                    }

                    if (b==3){
                        db.showVrach();
                    }

                    if (b==4){
                        db.showOb();
                    }

                    if (b==5){
                        System.out.println("1 Список кабинетов без оборудования 2 Список кабинетов с оборудованием");
                        int kab= scan.nextInt();

                        if (kab==1){
                            db.showKab();
                        }
                        if(kab==2){
                            db.showKabSObor();
                        }

                    }

                    if (b==6){
                        db.showOtdel(); db.showVrach(); db.showBolnoi();
                    }

                    if (b==7){
                        System.out.println("1 По отделению 2 Весь список по отделениям");
                        int s = scan.nextInt();
                        if (s==1){
                            db.showPoOtdel();
                        }
                        if (s==2){
                            db.showVsePoOtdel();
                        }
                    }

                    else{break ;}
                    break ;
                case 7:
                    System.out.println("Сохранение....");
                    db.save();

                    break;
                default:db.save();
                    break mark;
            }
        }

}
}

