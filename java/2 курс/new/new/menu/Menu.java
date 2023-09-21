package menu;

import domain.*;
import service.Service;
import service.ServicePalat;
import java.sql.SQLException;

import java.util.Scanner;


public class Menu {

    Scanner keyboard = new Scanner(System.in);

    private final Service<Bolnoi> serviceBolnoi;
    private final Service<Otdel> serviceOtdel;
    private final Service<Vrach> serviceVrach;
    private  final Service<MedSister> serviceMedSister;
    private  final ServicePalat servicePalat;
    private final Service<Kabinet> serviceKabinet;
    private final  Service<Oborydovanie> serviceOborydovanie;
    Draw draw;


    public Menu(Service<Bolnoi> serviceBolnoi, Service<Otdel> serviceOtdel, Service<Vrach> serviceVrach, Service<MedSister> serviceMedSister, Service<Palat> servicePalat, Service<Kabinet> serviceKabinet, Service<Oborydovanie> serviceOborydovanie) {
        this.serviceBolnoi = serviceBolnoi;
        this.serviceOtdel = serviceOtdel;
        this.serviceVrach = serviceVrach;
        this.serviceMedSister = serviceMedSister;
        this.servicePalat = (ServicePalat) servicePalat;
        this.serviceKabinet = serviceKabinet;
        this.serviceOborydovanie = serviceOborydovanie;
        this.draw=new Draw(this);
    }

    public void draw() throws SQLException {
        System.out.println("------ MENU ------");

        System.out.println("1. Отделы");
        System.out.println("2. Больные");
        System.out.println("3. Мед персонал");
        System.out.println("4. Оборудование");
        System.out.println("5. Кабинеты");
        System.out.println("6. Палаты");
        System.out.println("7. Списки");
        System.out.println("9. Выход");

        execute();
    }

    private void execute() throws SQLException {
        int command = keyboard.nextInt();

        switch (command) {
            case 1 -> draw.drawOtdel();
            case 2 -> draw.drawBolnoi();
            case 3-> draw.drawMedPers();
            case 4-> draw.drawOborydovanie();
            case 5-> draw.drawKabinet();
            case 6-> draw.drawPalat();
            case 7-> drawLists();
            case 9 -> System.exit(0);
            default -> throw new IllegalArgumentException("No command found");
        }
    }

    private void drawLists() throws SQLException {
        System.out.println("--- Списки ---");
        System.out.println("1. Вывести всех больных");
        System.out.println("2. Вывести всех врачей");
        System.out.println("3. Вывести все отделения");
        System.out.println("4. Вывести все кабинеты");
        System.out.println("5. Вывести все кабинеты по отделам");
        System.out.println("6. Вывести больных по врачам");
        System.out.println("7. Вывести палаты по отделам");
        System.out.println("");
        System.out.println("0. Назад в меню");
        int d=keyboard.nextInt();

        switch (d){
            case 1 -> {
                draw.drawBolnoiList();
                draw();
            }
            case 2 -> {
                draw.drawVrachList();
                drawLists();
            }

            case 3 -> {
                draw.drawOtdelList();
                drawLists();
            }
            case 4->{
                draw.drawKabinetListFull();
            }
            case 5 ->{
                draw.drawListKabinetPoOtdel();
            }
            case 6->{
                draw.drawListBolnoiPoVrach();
            }
            case 7->{
                draw.drawListPalatPoOtdel();
            }
            case 0-> draw();
        }
    }




}