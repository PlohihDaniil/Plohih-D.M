package menu;

import domain.*;
import repository.*;
import service.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Update {
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Bolnoi> serviceBolnoi= new ServiceBolnoi(new SQLBolnoiRepository());
    Service<Kabinet> serviceKabinet= new ServiceKabinet(new SQLKabinetRepository());
    Service<MedSister> serviceMedSister= new ServiceMedSister(new SQLMedSisterRepository());
    Service<Oborydovanie> serviceOborydovanie= new ServiceOborydovanie(new SQLOborydovanieRepository());
    Service<Palat> servicePalat= new ServicePalat(new SQLPalatRepository());
    Service<Vrach> serviceVrach= new ServiceVrach(new SQLVrachRepository());

    Scanner keyboard = new Scanner(System.in);
    Draw draw;
    Menu menu;

    public Update(Draw draw,Menu menu) {
        this.draw=draw;
        this.menu=menu;
    }

    void changeBolnoi() throws SQLException {
        int q=0;
        draw.drawBolnoiList();
        System.out.print("Выберите больного: ");
        long id = keyboard.nextLong();
        Bolnoi bolnoi = draw.drawSingleBolnoi(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Палату");
            System.out.println("6. Врачей");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); bolnoi.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); bolnoi.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); bolnoi.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); bolnoi.setDate( keyboard.nextInt() );
                }
                case 5->{
                    System.out.println("Выберите новую палату : ");draw.drawPalatList( bolnoi.getId_otdel() ); bolnoi.setId_palat( keyboard.nextLong() );
                }
                case 6->{
                    System.out.println("В разработке!!!");
                }
                case 9 -> {
                    draw.drawBolnoi();
                    q=1;
                }
                case 0 -> {
                    serviceBolnoi.update(bolnoi);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void changeKabinet() throws SQLException {
        int q=0;
        draw.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        draw.drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        long id = keyboard.nextLong();
        Kabinet kabinet = draw.drawSingleKabinet(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Название");
            System.out.println("2. Оборудование");
            System.out.println("3. Отдел");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); kabinet.setName( keyboard.next() );
                }
                case 2->{
                    System.out.println("1. Удалить");
                    System.out.println("2. Добавить");
                    System.out.println("0. Вернуться");
                    int a=keyboard.nextInt();
                    switch (a){
                        case 1->{
                            draw.drawOborydovaniePoIdKab(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = draw.singleOborydovanie(w);
                                oborydovanie.setId_kab(0L);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 2->{
                            draw.drawOborydovanieListFree();
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = draw.singleOborydovanie(w);
                                oborydovanie.setId_kab(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> changeKabinet();
                    }

                }
                case 3->{
                    draw.drawOtdelList();
                    System.out.println("Выберите новый отдел");
                    kabinet.setId_otdel(keyboard.nextLong() );
                }
                case 0 -> {
                    serviceKabinet.update(kabinet);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void changeMedSister() throws SQLException {
        int q=0;
        draw.drawMedSisterList();
        System.out.print("Выберите мед сестру: ");
        long id = keyboard.nextLong();
        MedSister medSister = draw.drawSingleMedSister(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Отедал и кабинет");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); medSister.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); medSister.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); medSister.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); medSister.setDate( keyboard.nextInt() );
                }
                case 5->{
                    Long id_otdel=keyboard.nextLong();
                    System.out.println("Выберите новый отдел: ");draw.drawOtdelList(); medSister.setId_otdel( id_otdel );
                    System.out.println("Выберите новый кабинет: ");draw.drawKabinetList(id_otdel); medSister.setIdKab( keyboard.nextLong() );
                }
                case 9 -> {
                    draw.drawMedSister();
                    q=1;
                }
                case 0 -> {
                    serviceMedSister.update(medSister);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void changeOborydovanie() throws SQLException {
        int q=0;
        draw.drawOborydovanieList();
        System.out.print("Выберите оборудование:");
        Long id_oboryd= keyboard.nextLong();

        Oborydovanie oborydovanie = draw.drawSingleOborydovanie(id_oboryd);

        while (q==0) {
            System.out.println("Что хотите изменить?");
            System.out.println("1. Название");
            System.out.println("2. Номер");
            System.out.println("3. Кабинет");
            System.out.println("4. Палату");
            System.out.println("");
            System.out.println("0. Сохранить и выйти");
            int w=keyboard.nextInt();
            switch (w){
                case 1->{
                    System.out.print("Новое название: ");
                    oborydovanie.setName(keyboard.next() );
                }
                case 2->{
                    System.out.println("Новый номер: ");
                    oborydovanie.setNumber( keyboard.nextInt() );
                }
                case 3->{
                    if(oborydovanie.getId_palat() == 0){

                        draw.drawListKabinetPoOtdel();
                        System.out.println("В данный момент находится");
                        draw.drawSingleKabinet( oborydovanie.getId_kab() );
                        System.out.println("Выберите новый кабинет");
                        oborydovanie.setId_kab(keyboard.nextLong() );

                    }else {
                        System.out.println("Сначало удалите палату!!!");
                    }
                }
                case 4->{
                    if(oborydovanie.getId_kab() == 0){

                        draw.drawListPalatPoOtdel();
                        System.out.println("В данный момент находится");
                        draw.drawSinglePalat( oborydovanie.getId_kab() );
                        System.out.println("Выберите новую палату ");
                        oborydovanie.setId_palat(keyboard.nextLong() );


                    }else {
                        System.out.println("Сначало удалите кабинет!!!");
                    }
                }
                case 0 ->{
                    serviceOborydovanie.update(oborydovanie);
                    menu.draw();
                    q+=1;
                }
            }

        }
    }
    void changeOtdel() throws SQLException {
        int q =0;
        draw.drawOtdelList();
        System.out.print("Выберите какой отдел хотите изменить: ");
        Long id= keyboard.nextLong();
        try {

            Otdel otdel = draw.drawSingleOtdel(id);

            while (q==0){
                System.out.println("Выберите что хотите изменить");
                System.out.println("1. Название");
                System.out.println("9. Назад");
                System.out.println("0. Сохранить и выйти");
                int d= keyboard.nextInt();

                switch (d){
                    case 1->{
                        System.out.print("Новое название отдела:"); otdel.setName( keyboard.next() );
                    }
                    case 9->{
                        q=1;
                        draw.drawOtdel();
                    }
                    case 0->{
                        q=1;
                        serviceOtdel.update(otdel);
                        menu.draw();
                    }
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    void changePalat() throws SQLException {
        int q=0;
        draw.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        draw.drawPalatList(id_otdel);
        System.out.print("Выберите палату: ");
        long id = keyboard.nextLong();
        Palat palat = draw.drawSinglePalat(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Отдел");
            System.out.println("2. Оборудование");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    draw.drawOtdelList();
                    System.out.print("Выберите новый отдел: "); palat.setId_otdel( keyboard.nextLong() );
                }
                case 2->{
                    System.out.println("1. Удалить");
                    System.out.println("2. Добавить");
                    System.out.println("0. Вернуться");
                    int a=keyboard.nextInt();
                    switch (a){
                        case 1->{
                            draw.drawOborydovaniePoIdPalat(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = draw.singleOborydovanie(w);
                                oborydovanie.setId_palat(0L);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 2->{
                            draw.drawOborydovanieListFree();
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = draw.singleOborydovanie(w);
                                oborydovanie.setId_palat(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> changeKabinet();
                    }

                }
                case 0 -> {
                    servicePalat.update(palat);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    void changeVrach() throws SQLException {
        int q=0;
        draw.drawVrachList();
        System.out.print("Выберите врача: ");
        long id = keyboard.nextLong();
        Vrach vrach = draw.drawSingleVrach(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Имя");
            System.out.println("2. Пол");
            System.out.println("3. ИНН");
            System.out.println("4. Возраст");
            System.out.println("5. Отдел");
            System.out.println("6. Кабинет");
            System.out.println("9. Назад");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    System.out.print("Введите новове имя: "); vrach.setSurname( keyboard.next() );
                }
                case 2->{
                    System.out.print("Введите новый пол: "); vrach.setPol( keyboard.next() );
                }
                case 3-> {
                    System.out.print("Введите новове INN: "); vrach.setInn( keyboard.nextInt() );
                }
                case 4->{
                    System.out.print("Введите новый возраст: "); vrach.setDate( keyboard.nextInt() );
                }
                case 5->{
                    draw.drawOtdelList();
                    System.out.print("Выберите новый отдел: "); vrach.setId_otdel( keyboard.nextLong() );
                }
                case 6->{
                    draw.drawKabinetList( vrach.getId_otdel() );
                    System.out.print("Выберите новый кабинет: ");
                    Kabinet kabinet = draw.drawSingleKabinet(keyboard.nextLong() );
                    vrach.setKab(kabinet.getName() );
                    vrach.setIdKab(kabinet.getId() );
                }
                case 9 -> {
                    draw.drawBolnoi();
                    q=1;
                }
                case 0 -> {
                    serviceVrach.update(vrach);
                    menu.draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
}
