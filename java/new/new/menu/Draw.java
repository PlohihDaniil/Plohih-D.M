package menu;

import domain.*;
import repository.*;
import service.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;


public class Draw{
    Scanner keyboard = new Scanner(System.in);
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Bolnoi> serviceBolnoi= new ServiceBolnoi(new SQLBolnoiRepository());
    Service<Kabinet> serviceKabinet= new ServiceKabinet(new SQLKabinetRepository());
    Service<MedSister> serviceMedSister= new ServiceMedSister(new SQLMedSisterRepository());
    Service<Oborydovanie> serviceOborydovanie= new ServiceOborydovanie(new SQLOborydovanieRepository());
    Service<Palat> ServicePalat= new ServicePalat(new SQLPalatRepository());
    Service<Vrach> serviceVrach= new ServiceVrach(new SQLVrachRepository());



    New now;
    Delete delete;
    Update update;
    Menu menu;



    public Draw(Menu menu){
        this.now=new New(this);
        this.delete=new Delete(this);
        this.update=new Update(this,menu);
        this.menu = menu;
    }

    void drawVrach() throws SQLException {
        System.out.println("--- Врачи ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> now.newVrach();
            case 2-> delete.deleteVrach();
            case 3-> update.changeVrach();
            case 9-> drawMedPers();
            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }

    }
    void drawMedPers() throws SQLException {
        System.out.println("--- Мед персонал ---");
        System.out.println("1. Врачи");
        System.out.println("2. Мед сестры");
        System.out.println("9. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> drawVrach();
            case 2-> drawMedSister();

            case 9-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    void drawMedSister() throws SQLException {
        System.out.println("--- Мед сестры ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> now.newMedSister();
            case 2-> delete.deleteMedSister();
            case 3-> update.changeMedSister();

            case 9-> drawMedPers();
            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    void drawKabinet() throws SQLException {
        System.out.println("--- Кабинеты ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> now.newKabinet();
            case 2-> delete.deleteKabinet();
            case 3-> update.changeKabinet();

            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    void drawBolnoi() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){

            case 1 ->now.newBolnoi();
            case 2-> delete.deleteBolnoi();
            case 3-> update.changeBolnoi();
            case 9-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    void drawOborydovanie() throws SQLException {
        System.out.println("--- Оборудование ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> now.newOborydovanie();
            case 2-> delete.deleteOborydovanie();
            case 3-> update.changeOborydovanie();

            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    void drawOtdel() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->{
                now.newOtdel();
            }
            case 2->{
                delete.deleteOtdel();
            }
            case 3->{
                update.changeOtdel();
            }
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    void drawPalat() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->now.newPalat();
            case 2-> delete.deletePalat();
            case 3-> update.changePalat();
            case 9-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }


    Bolnoi drawSingleBolnoi(Long id) throws SQLException {
        System.out.println("---- Single bolnoi ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
        return bolnoi;
    }
    void drawBolnoiList() throws SQLException {
        System.out.println();
        System.out.println("---- Bolnoi list ----");
        serviceBolnoi.getAll().forEach(System.out::println);
    }
    void drawListBolnoiPoVrach() throws SQLException {
        List<Vrach> vraches=serviceVrach.getAll();
        System.out.println("--- Список больных по врачам ---");
        for (Vrach vrach : vraches) {

            System.out.println(vrach.getId() + " " + vrach.getSurname());
            List<Bolnoi> list = serviceBolnoi.listPoId(vrach.getId());
            if (list.size() != 0) {
                for (Bolnoi bolnoi : list) {
                    System.out.println("   " + bolnoi.getId() + " " + bolnoi.getSurname());
                }
            } else {
                System.out.println("--- Пусто ---");
            }
        }
    }


    void drawKabinetListFull() throws SQLException {
        System.out.println();
        System.out.println("--- Kabinet list ---");
        serviceKabinet.getAll().forEach(System.out::println);
    }
    void drawKabinetList(Long id) throws SQLException {
        System.out.println();
        System.out.println("--- Kabinet list ---");
        serviceKabinet.getList(id).forEach(System.out::println);
    }
    Kabinet drawSingleKabinet(Long id) throws SQLException {
        System.out.println("---- Single kabinet ----");
        Kabinet kabinet = serviceKabinet.getById(id);
        System.out.println(kabinet);
        return kabinet;
    }
    void drawListKabinetPoOtdel() throws SQLException {
        System.out.println("--- Список кабинетов по отдела ---");
        List<Otdel> otdel = serviceOtdel.getAll();
        for (int i=1;i<otdel.size();i++){
            System.out.println( otdel.get(i).getName() );
            drawKabinetList( otdel.get(i).getId() );
            System.out.println();
            System.out.println("-----------------");
        }

    }

    MedSister drawSingleMedSister(Long id) throws SQLException {
        return serviceMedSister.getById(id);
    }
    void drawMedSisterList() throws SQLException {
        System.out.println();
        System.out.println("--- Med sister list ---");
        serviceMedSister.getAll().forEach(System.out::println);
    }

    void drawOborydovanieList() throws SQLException {
        System.out.println();
        System.out.println("--- Oborydovanie list ---");
        serviceOborydovanie.getAll().forEach(System.out::println);
    }
    Oborydovanie drawSingleOborydovanie(Long id) throws SQLException {
        System.out.println("---- Single Oborydovanie ----");
        Oborydovanie oborydovanie = serviceOborydovanie.getById(id);
        System.out.println(oborydovanie);
        return oborydovanie;
    }
    void drawOborydovanieListFree() throws SQLException {
        serviceOborydovanie.getListFree().forEach(System.out::println);

    }
    void drawOborydovaniePoIdKab(Long id) throws SQLException {
        serviceOborydovanie.listPoId(id).forEach(System.out::println);
    }
    void drawOborydovaniePoIdPalat(Long id) throws SQLException {
        serviceOborydovanie.getListPoId(id).forEach(System.out::println);
    }
    Oborydovanie singleOborydovanie(Long id) throws SQLException {
        return serviceOborydovanie.getById(id);
    }

    void drawOtdelList() throws SQLException {
        System.out.println();
        System.out.println("--- Otdel list ---");
        serviceOtdel.getAll().forEach(System.out::println);
    }
    Otdel drawSingleOtdel(Long id)throws  SQLException{
        System.out.println("--- Single otdel ---");
        Otdel otdel = serviceOtdel.getById(id);
        System.out.println(otdel);
        return otdel;
    }


    void drawPalatList(Long id) throws SQLException {
        System.out.println();
        System.out.println("---- Palat list ----");
        ServicePalat.oneList(id).forEach(System.out::println);
    }
    void drawListPalatPoOtdel() throws SQLException {
        System.out.println("--- Список палат по отделам ---");
        List<Otdel> otdel = serviceOtdel.getAll();
        for (int i=1;i<otdel.size();i++){
            System.out.println( otdel.get(i).getName() );
            drawPalatList( otdel.get(i).getId());
            System.out.println();
            System.out.println("-----------------");
        }
    }
    Palat drawSinglePalat(Long id) throws SQLException {
        System.out.println("---- Single Palat ----");
        Palat palat = ServicePalat.getById(id);
        System.out.println(palat);
        return palat;
    }


    void drawVrachList() throws SQLException {
        System.out.println();
        System.out.println("--- Vrach list ---");
        serviceVrach.getAll().forEach(System.out::println);
    }
    Vrach drawSingleVrach(Long id) throws SQLException {
        System.out.println("--- Single otdel ---");
        Vrach vrach = serviceVrach.getById(id);
        System.out.println(vrach);
        return vrach;
    }

}
