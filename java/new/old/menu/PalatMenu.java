package menu;

import domain.Oborydovanie;
import domain.Otdel;
import domain.Palat;
import repository.SQLOborydovanieRepository;
import repository.SQLOtdelRepository;
import repository.SQLPalatRepository;
import service.Service;
import service.ServiceOborydovanie;
import service.ServiceOtdel;
import service.ServicePalat;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PalatMenu {
    Service<Palat> ServicePalat = new ServicePalat(new SQLPalatRepository());
    Service<Otdel> serviceOtdel = new ServiceOtdel(new SQLOtdelRepository());
    Service<Oborydovanie> serviceOborydovanie = new ServiceOborydovanie(new SQLOborydovanieRepository());
    Service<Palat> servicePalat = new ServicePalat(new SQLPalatRepository());
    private OtdelMenu otdelMenu;
    private  PalatMenu palatMenu;
    private Menu menu;
    private OborydovanieMenu oborydovanieMenu;
    private KabinetMenu kabinetMenu;

    Scanner keyboard = new Scanner(System.in);



    // TODO: 28.11.2022 палаты
    void changePalat() throws SQLException {
        int q=0;
        otdelMenu.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        palatMenu.drawPalatList(id_otdel);
        System.out.print("Выберите палату: ");
        long id = keyboard.nextLong();
        Palat palat = palatMenu.drawSinglePalat(id);

        while (q==0){
            System.out.println("Что хотите изменить?");
            System.out.println("1. Отдел");
            System.out.println("2. Оборудование");
            System.out.println("0. Сохранить и выйти");

            int d=keyboard.nextInt();

            switch (d){
                case 1-> {
                    otdelMenu.drawOtdelList();
                    System.out.print("Выберите новый отдел: "); palat.setId_otdel( keyboard.nextLong() );
                }
                case 2->{
                    System.out.println("1. Удалить");
                    System.out.println("2. Добавить");
                    System.out.println("0. Вернуться");
                    int a=keyboard.nextInt();
                    switch (a){
                        case 1->{
                            oborydovanieMenu.drawOborydovaniePoIdPalat(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = oborydovanieMenu.singleOborydovanie(w);
                                oborydovanie.setId_palat(0L);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 2->{
                            oborydovanieMenu.drawOborydovanieListFree();
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = oborydovanieMenu.singleOborydovanie(w);
                                oborydovanie.setId_palat(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> kabinetMenu.changeKabinet();
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
    void drawPalat() throws SQLException {
        System.out.println("1. Добавить");
        System.out.println("2. Удалить");
        System.out.println("3. Редактировать");
        System.out.println("9. Вернуться назад");

        int number = keyboard.nextInt();

        switch (number){
            case 1 ->palatMenu.newPalat();
            case 2-> palatMenu.deletePalat();
            case 3-> changePalat();
            case 9-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    void newPalat() throws SQLException {
        System.out.println("--- Введите данные ---");
        otdelMenu.drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = otdelMenu.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Palat palat = new Palat(null,id_otdel,ot);
        ServicePalat.save(palat);
        System.out.println("--- Завершено ---");
    }
    void deletePalat() throws SQLException {
        otdelMenu.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawPalatList(id_otdel);
        System.out.println("Выберите какую палату хотите удалить: ");
        Long id= keyboard.nextLong();
        Palat palat = drawSinglePalat(id);
        ServicePalat.delete(palat);
    }

    void drawPalatList(Long id) throws SQLException {
        System.out.println();
        System.out.println("---- Palat list ----");
        ServicePalat.oneList(id).forEach(System.out::println);
    }
    Palat drawSinglePalat(Long id) throws SQLException {
        System.out.println("---- Single Palat ----");
        Palat palat = ServicePalat.getById(id);
        System.out.println(palat);
        return palat;
    }
    void drawListPalatPoOtdel() throws SQLException {
        System.out.println("--- Список палат по отделам ---");
        List<Otdel> otdel = serviceOtdel.getAll();
        for (int i=1;i<otdel.size();i++){
            System.out.println( otdel.get(i).getName() );
            palatMenu.drawPalatList( otdel.get(i).getId());
            System.out.println();
            System.out.println("-----------------");
        }
    }


}
