package menu;

import domain.*;
import service.Service;
import service.ServicePalat;


import javax.crypto.spec.PSource;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;


public class Menu {
    LocalDate data = LocalDate.now();

    Scanner keyboard = new Scanner(System.in);
    private final Service<Bolnoi> serviceBolnoi;
    private final Service<Otdel> serviceOtdel;
    private final Service<Vrach> serviceVrach;
    private  final Service<MedSister> serviceMedSister;
    private  final ServicePalat servicePalat;
    private final Service<Kabinet> serviceKabinet;
    private final  Service<Oborydovanie> serviceOborydovanie;

    public Menu(Service<Bolnoi> serviceBolnoi, Service<Otdel> serviceOtdel, Service<Vrach> serviceVrach, Service<MedSister> serviceMedSister, Service<Palat> servicePalat, Service<Kabinet> serviceKabinet, Service<Oborydovanie> serviceOborydovanie) {
        this.serviceBolnoi = serviceBolnoi;
        this.serviceOtdel = serviceOtdel;
        this.serviceVrach = serviceVrach;
        this.serviceMedSister = serviceMedSister;
        this.servicePalat = (ServicePalat) servicePalat;
        this.serviceKabinet = serviceKabinet;
        this.serviceOborydovanie = serviceOborydovanie;
    }

    // TODO: 28.11.2022 доделать палаты
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
            case 1 -> drawOtdel();
            case 2 -> drawBolnoi();
            case 3-> drawMedPers();
            case 4-> drawOborydovanie();
            case 5-> drawKabinet();
            case 6-> drawPalat();
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
                drawBolnoiList();
                draw();
            }
            case 2 -> {
                drawVrachList();
                drawLists();
            }

            case 3 -> {
                drawOtdelList();
                drawLists();
            }
            case 4->{
                drawKabinetListFull();
            }
            case 5 ->{
                drawListKabinetPoOtdel();
            }
            case 6->{
                drawListBolnoiPoVrach();
            }
            case 7->{
                drawListPalatPoOtdel();
            }
            case 0-> draw();
        }
    }


    // TODO: 28.11.2022 Оборудование
    private void drawOborydovanie() throws SQLException {
        System.out.println("--- Оборудование ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newOborydovanie();
            case 2-> deleteOborydovanie();
            case 3-> changeOborydovanie();

            case 0-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    private void newOborydovanie() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.print("Название оборудования: ");
        String name = keyboard.next();

        System.out.print("Номер оборудования:");
        int number = keyboard.nextInt();

        System.out.println("Где будет стоять оборудование");
        System.out.println("1. В палате");
        System.out.println("2. В кабинете");
        System.out.println("3. На складе");
        int s=keyboard.nextInt();
        long id_kab = 0L;
        long id_palat = 0L;
        switch (s){
            case 1->{
                drawOtdelList();
                System.out.print("Выберите отдел:");
                drawPalatList( keyboard.nextLong() );
                System.out.print("Выберите палату:");
                id_palat = keyboard.nextLong();
            }
            case 2->{
                drawOtdelList();
                System.out.print("Выберите отдел:");
                drawKabinetList( keyboard.nextLong() );
                System.out.print("Выберите кабинет: ");
                id_kab = keyboard.nextLong();
            }
            case 3->{

            }
        }


        Oborydovanie oborydovanie = new Oborydovanie(null,name,number,id_kab,id_palat);
        serviceOborydovanie.save(oborydovanie);
    }
    private void deleteOborydovanie() throws SQLException {
        drawOborydovanieList();
        System.out.print("Выберите какое оборудование удалить :");
        Oborydovanie oborydovanie = drawSingleOborydovanie( keyboard.nextLong() );
        serviceOborydovanie.delete( oborydovanie );
    }
    private void changeOborydovanie() throws SQLException {
        int q=0;
        drawOborydovanieList();
        System.out.print("Выберите оборудование:");
        Long id_oboryd= keyboard.nextLong();

        Oborydovanie oborydovanie = drawSingleOborydovanie(id_oboryd);

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

                        drawListKabinetPoOtdel();
                        System.out.println("В данный момент находится");
                        drawSingleKabinet( oborydovanie.getId_kab() );
                        System.out.println("Выберите новый кабинет");
                        oborydovanie.setId_kab(keyboard.nextLong() );

                    }else {
                        System.out.println("Сначало удалите палату!!!");
                    }
                }
                case 4->{
                    if(oborydovanie.getId_kab() == 0){

                        drawListPalatPoOtdel();
                        System.out.println("В данный момент находится");
                        drawSinglePalat( oborydovanie.getId_kab() );
                        System.out.println("Выберите новую палату ");
                        oborydovanie.setId_palat(keyboard.nextLong() );


                    }else {
                        System.out.println("Сначало удалите кабинет!!!");
                    }
                }
                case 0 ->{
                    serviceOborydovanie.update(oborydovanie);
                    draw();
                    q+=1;
                }
            }

        }
    }
    private void drawOborydovanieList() throws SQLException {
        System.out.println();
        System.out.println("--- Oborydovanie list ---");
        serviceOborydovanie.getAll().forEach(System.out::println);
    }
    private Oborydovanie drawSingleOborydovanie(Long id) throws SQLException {
        System.out.println("---- Single Oborydovanie ----");
        Oborydovanie oborydovanie = serviceOborydovanie.getById(id);
        System.out.println(oborydovanie);
        return oborydovanie;
    }
    private void drawOborydovanieListFree() throws SQLException {
        serviceOborydovanie.getListFree().forEach(System.out::println);

    }
    private Oborydovanie singleOborydovanie(Long id) throws SQLException {
        return serviceOborydovanie.getById(id);
    }



    // TODO: 28.11.2022 кабинеты
    private void drawKabinet() throws SQLException {
        System.out.println("--- Кабинеты ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("0. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newKabinet();
            case 2-> deleteKabinet();
            case 3-> changeKabinet();

            case 0-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    private void newKabinet() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Название кабинета: ");
        String name = keyboard.next();

        drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Kabinet kabinet = new Kabinet(null,name,id_otdel,ot);
        serviceKabinet.save(kabinet);
    }
    private  void deleteKabinet() throws SQLException {
        drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawKabinetList(id_otdel);
        System.out.println("Выберите какой кабинет зотите удалить: ");
        Long id= keyboard.nextLong();
       Kabinet kabinet = drawSingleKabinet(id);
        serviceKabinet.delete(kabinet);
    }

    private void changeKabinet() throws SQLException {
        int q=0;
        drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        long id = keyboard.nextLong();
        Kabinet kabinet = drawSingleKabinet(id);

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
                            drawOborydovaniePoIdKab(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = singleOborydovanie(w);
                                oborydovanie.setId_kab(0L);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 2->{
                            drawOborydovanieListFree();
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = singleOborydovanie(w);
                                oborydovanie.setId_kab(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> changeKabinet();
                    }

                }
                case 3->{
                    drawOtdelList();
                    System.out.println("Выберите новый отдел");
                    kabinet.setId_otdel(keyboard.nextLong() );
                }
                case 0 -> {
                    serviceKabinet.update(kabinet);
                    draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    private void drawKabinetListFull() throws SQLException {
        System.out.println();
        System.out.println("--- Kabinet list ---");
        serviceKabinet.getAll().forEach(System.out::println);
    }
    private void drawKabinetList(Long id) throws SQLException {
        System.out.println();
        System.out.println("--- Kabinet list ---");
        serviceKabinet.getList(id).forEach(System.out::println);
    }
    private Kabinet drawSingleKabinet(Long id) throws SQLException {
        System.out.println("---- Single kabinet ----");
        Kabinet kabinet = serviceKabinet.getById(id);
        System.out.println(kabinet);
        return kabinet;
    }

    // TODO: 28.11.2022 Мед сестры
    private void drawmedSister() throws SQLException {
        System.out.println("--- Мед сестры ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newMedSister();
            case 2-> deleteMedSister();
            case 3-> changeMedSister();

            case 9-> drawMedPers();
            case 0-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    private void newMedSister() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Имя: ");
        String name = keyboard.next();

        System.out.println("Пол: ");
        String pol = keyboard.next();

        System.out.println("Год рождения: ");
        int date = data.getYear() - keyboard.nextInt();

        System.out.println("INN: ");
        int inn = keyboard.nextInt();

        System.out.println("З/п : ");
        int zp = keyboard.nextInt();

        drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        MedSister medSister= new MedSister(null,ot,zp,pol,name,date,inn,idKab,id_otdel,kab);
        serviceMedSister.save(medSister);
    }
    private void deleteMedSister() throws SQLException {
        drawMedSisterList();
        Long id= keyboard.nextLong();
        MedSister medSister = drawSingleMedSister(id);
        serviceMedSister.delete(medSister);
    }
    private void changeMedSister() throws SQLException {
        int q=0;
        drawMedSisterList();
        System.out.print("Выберите мед сестру: ");
        long id = keyboard.nextLong();
        MedSister medSister = drawSingleMedSister(id);

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
                    System.out.println("Выберите новый отдел: ");drawOtdelList(); medSister.setId_otdel( id_otdel );
                    System.out.println("Выберите новый кабинет: ");drawKabinetList(id_otdel); medSister.setIdKab( keyboard.nextLong() );
                }
                case 9 -> {
                    drawmedSister();
                    q=1;
                }
                case 0 -> {
                    serviceMedSister.update(medSister);
                    draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    private  void drawMedSisterList() throws SQLException {
        System.out.println();
        System.out.println("--- Med sister list ---");
        serviceMedSister.getAll().forEach(System.out::println);
    }
    private MedSister drawSingleMedSister(Long id) throws SQLException {
        return serviceMedSister.getById(id);
    }

    // TODO: 28.11.2022 врачи

    private void drawVrach() throws SQLException {
        System.out.println("--- Врачи ----");
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Назад");
        System.out.println("0. Выйти в меню");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> newVrach();
            case 2-> deleteVrach();
            case 3-> changeVrach();
            case 9-> drawMedPers();
            case 0-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }

    }

    private void newVrach() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Имя: ");
        String name = keyboard.next();

        System.out.println("Пол: ");
        String pol = keyboard.next();

        System.out.println("Год рождения: ");
        int date = data.getYear() - keyboard.nextInt();

        System.out.println("INN: ");
        int inn = keyboard.nextInt();

        System.out.println("З/п : ");
        int zp = keyboard.nextInt();

        drawOtdelList();
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        drawKabinetList(id_otdel);
        System.out.print("Выберите кабинет: ");
        Long idKab= keyboard.nextLong();
        Kabinet kabinet = drawSingleKabinet(idKab);
        String kab = kabinet.getName();

        Vrach vrach = new Vrach(null, ot, zp, pol, name, date, inn, id_otdel, idKab, kab);
        serviceVrach.save(vrach);
    }
    private void deleteVrach() throws SQLException {
        drawVrachList();
        Long id= keyboard.nextLong();
        Vrach vrach = drawSingleVrach(id);
        serviceVrach.delete(vrach);
    }

    private void changeVrach() throws SQLException {
        int q=0;
        drawVrachList();
        System.out.print("Выберите врача: ");
        long id = keyboard.nextLong();
        Vrach vrach = drawSingleVrach(id);

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
                    drawOtdelList();
                    System.out.print("Выберите новый отдел: "); vrach.setId_otdel( keyboard.nextLong() );
                }
                case 6->{
                    drawKabinetList( vrach.getId_otdel() );
                    System.out.print("Выберите новый кабинет: ");
                    Kabinet kabinet = drawSingleKabinet(keyboard.nextLong() );
                    vrach.setKab(kabinet.getName() );
                    vrach.setIdKab(kabinet.getId() );
                }
                case 9 -> {
                    drawBolnoi();
                    q=1;
                }
                case 0 -> {
                    serviceVrach.update(vrach);
                    draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }
    private void drawVrachList() throws SQLException {
        System.out.println();
        System.out.println("--- Vrach list ---");
        serviceVrach.getAll().forEach(System.out::println);
    }
    private Vrach drawSingleVrach(Long id) throws SQLException {
        System.out.println("--- Single otdel ---");
        Vrach vrach = serviceVrach.getById(id);
        System.out.println(vrach);
        return vrach;
    }


    // TODO: 28.11.2022 отделы
    private void drawOtdel() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->{
                newOtdel();
            }
            case 2->{
                deleteOtdel();
            }
            case 3->{
                changeOtdel();
            }
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    private void deleteOtdel() throws SQLException {
        drawOtdelList();
        System.out.print("Выберите отдел который хотите удалить: ");
        Long id= keyboard.nextLong();
        try {
            Otdel otdel = drawSingleOtdel(id);

            serviceOtdel.delete(otdel);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private void newOtdel() throws SQLException {
        System.out.print("Введите название нового отдела: "); String name = keyboard.next();

        Otdel otdel = new Otdel(null, name);
        serviceOtdel.save(otdel);
    }
    private void changeOtdel() throws SQLException {
        int q =0;
        drawOtdelList();
        System.out.print("Выберите какой отдел хотите изменить: ");
        Long id= keyboard.nextLong();
        try {

            Otdel otdel = drawSingleOtdel(id);

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
                        drawOtdel();
                    }
                    case 0->{
                        q=1;
                        serviceOtdel.update(otdel);
                        draw();
                    }
                }


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    private  Otdel drawSingleOtdel(Long id)throws  SQLException{
        System.out.println("--- Single otdel ---");
        Otdel otdel = serviceOtdel.getById(id);
        System.out.println(otdel);
        return otdel;
    }
    private  void drawOtdelList() throws SQLException {
        System.out.println();
        System.out.println("--- Otdel list ---");
        serviceOtdel.getAll().forEach(System.out::println);
    }

    // TODO: 28.11.2022 больные
    private void drawBolnoi() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->newBolnoi();
            case 2-> deleteBolnoi();
            case 3->changeBolnoi();
            case 9-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    // TODO: 28.11.2022 добавить изменение врачей
    private void changeBolnoi() throws SQLException {
        int q=0;
        drawBolnoiList();
        System.out.print("Выберите больного: ");
        long id = keyboard.nextLong();
        Bolnoi bolnoi = drawSingleBolnoi(id);

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
                System.out.println("Выберите новую палату : ");drawPalatList( bolnoi.getId_otdel() ); bolnoi.setId_palat( keyboard.nextLong() );
            }
            case 6->{
                System.out.println("В разработке!!!");
            }
            case 9 -> {
                drawBolnoi();
                q=1;
            }
            case 0 -> {
                serviceBolnoi.update(bolnoi);
                draw();
                q=1;
            }
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    }

    private Bolnoi drawSingleBolnoi(Long id) throws SQLException {
        System.out.println("---- Single bolnoi ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
        return bolnoi;
    }
    private void newBolnoi() throws SQLException {
        System.out.println("Введите данные больного");
        System.out.print("Имя: ");String name = keyboard.next();
        System.out.print("Пол: ");String pol = keyboard.next();
        System.out.print("Год рождения: ");int date = data.getYear() - keyboard.nextInt();
        System.out.print("ИНН: ");int inn = keyboard.nextInt();

        drawOtdelList();
        System.out.print("Выберите отделение:");
        long id_otdel = keyboard.nextLong();

        drawPalatList(id_otdel);
        System.out.println("Выберите палату в которую хотите отправить больного: ");
        Long id =keyboard.nextLong();

        Otdel otdel = serviceOtdel.getById(id_otdel);

        String ot = otdel.getName();

        Bolnoi o = new Bolnoi(null,ot,pol,name,date,inn,id,id_otdel);
    int q=0;

        drawVrachList();
        System.out.println("Выбирете врачей для больного:");

        while (q==0){
            Long id_vrach= keyboard.nextLong();

            Vrach vrach = drawSingleVrach(id_vrach);
            o.addVrach( vrach.getSurname() );
            o.addIdVrach( vrach.getId() );
            o.addVrachList( vrach );

            System.out.println("1. Еще добавить");
            System.out.println("2. Закончить");
            int s=keyboard.nextInt();
            switch (s){
                case 1->{

                }
                case 2-> q=1;
            }
        }

        serviceBolnoi.save(o);
    }
    private void drawBolnoiList() throws SQLException {
        System.out.println();
        System.out.println("---- Bolnoi list ----");
        serviceBolnoi.getAll().forEach(System.out::println);
    }
    private void deleteBolnoi() throws SQLException {
        drawBolnoiList();
        System.out.print("Выберите больного которого хотите удалить:");
        Bolnoi bolnoi = drawSingleBolnoi(keyboard.nextLong() );
        serviceBolnoi.delete(bolnoi);
    }


    // TODO: 28.11.2022 палаты
    private void drawPalat() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->newPalat();
            case 2-> deletePalat();
            case 3->changePalat();
            case 9-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }
    private void newPalat() throws SQLException {
        System.out.println("--- Введите данные ---");
        drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Palat palat = new Palat(null,id_otdel,ot);
        servicePalat.save(palat);
        System.out.println("--- Завершено ---");
    }
    private void deletePalat() throws SQLException {
        drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawPalatList(id_otdel);
        System.out.println("Выберите какую палату хотите удалить: ");
        Long id= keyboard.nextLong();
        Palat palat = drawSinglePalat(id);
        servicePalat.delete(palat);
    }

    private void changePalat() throws SQLException {
        int q=0;
        drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawPalatList(id_otdel);
        System.out.print("Выберите палату: ");
        long id = keyboard.nextLong();
        Palat palat = drawSinglePalat(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Отдел");
            System.out.println("2. Оборудование");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    drawOtdelList();
                    System.out.print("Выберите новый отдел: "); palat.setId_otdel( keyboard.nextLong() );
                }
                case 2->{
                    System.out.println("1. Удалить");
                    System.out.println("2. Добавить");
                    System.out.println("0. Вернуться");
                    int a=keyboard.nextInt();
                    switch (a){
                        case 1->{
                            drawOborydovaniePoIdPalat(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = singleOborydovanie(w);
                                oborydovanie.setId_palat(0L);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 2->{
                            drawOborydovanieListFree();
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = singleOborydovanie(w);
                                oborydovanie.setId_palat(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> changeKabinet();
                    }

                }
                case 0 -> {
                    servicePalat.update(palat);
                    draw();
                    q=1;
                }
                default -> System.out.println("Нет такого поля!!!");
            }
        }
    }

    private  void drawPalatList(Long id) throws SQLException {
        System.out.println();
        System.out.println("---- Palat list ----");
        servicePalat.oneList(id).forEach(System.out::println);
    }
    private  Palat drawSinglePalat(Long id) throws SQLException {
        System.out.println("---- Single Palat ----");
        Palat palat = servicePalat.getById(id);
        System.out.println(palat);
        return palat;
    }

    // TODO: 28.11.2022 другое

    private void drawSingleObject() throws SQLException {
        System.out.print("Enter object id: ");
        long id = keyboard.nextLong();
        System.out.println("---- Single object ----");
        Bolnoi bolnoi = serviceBolnoi.getById(id);
        System.out.println(bolnoi);
    }
    private void drawMedPers() throws SQLException {
        System.out.println("--- Мед персонал ---");
        System.out.println("1. Врачи");
        System.out.println("2. Мед сестры");
        System.out.println("9. Назад");
        int d= keyboard.nextInt();

        switch (d){
            case 1-> drawVrach();
            case 2-> drawmedSister();

            case 9-> draw();
            default -> System.out.println("Нет такого поля!!!");
        }

    }
    private void drawListKabinetPoOtdel() throws SQLException {
        System.out.println("--- Список кабинетов по отдела ---");
        List<Otdel> otdel = serviceOtdel.getAll();
        for (int i=1;i<otdel.size();i++){
            System.out.println( otdel.get(i).getName() );
            drawKabinetList( otdel.get(i).getId() );
            System.out.println();
            System.out.println("-----------------");
        }

    }
    private void drawListBolnoiPoVrach() throws SQLException {
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
    private  void drawListPalatPoOtdel() throws SQLException {
        System.out.println("--- Список палат по отделам ---");
        List<Otdel> otdel = serviceOtdel.getAll();
        for (int i=1;i<otdel.size();i++){
            System.out.println( otdel.get(i).getName() );
            drawPalatList( otdel.get(i).getId());
            System.out.println();
            System.out.println("-----------------");
        }
    }
    private void drawOborydovaniePoIdKab(Long id) throws SQLException {
        serviceOborydovanie.listPoId(id).forEach(System.out::println);
    }
    private void drawOborydovaniePoIdPalat(Long id) throws SQLException {
        serviceOborydovanie.getListPoId(id).forEach(System.out::println);
    }

}