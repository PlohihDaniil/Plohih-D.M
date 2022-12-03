package menu;

import domain.Kabinet;
import domain.Oborydovanie;
import domain.Otdel;
import repository.SQLKabinetRepository;
import repository.SQLOborydovanieRepository;
import repository.SQLOtdelRepository;
import service.Service;
import service.ServiceKabinet;
import service.ServiceOborydovanie;
import service.ServiceOtdel;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class KabinetMenu {
    Service<Kabinet> serviceKabinet = new ServiceKabinet(new SQLKabinetRepository());
    Service<Otdel> serviceOtdel = new ServiceOtdel( new SQLOtdelRepository());
    Service<Oborydovanie> serviceOborydovanie = new ServiceOborydovanie(new SQLOborydovanieRepository());
    private OtdelMenu otdelMenu;
    private Menu menu;
    private OborydovanieMenu oborydovanieMenu;
    Scanner keyboard = new Scanner(System.in);


    void drawKabinet() throws SQLException {
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

            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
    }

    void changeKabinet() throws SQLException {
        int q=0;
        otdelMenu.drawOtdelList();
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
                            oborydovanieMenu.drawOborydovaniePoIdKab(id);
                            long w;
                            do {
                                System.out.println("Выберите оборудование");
                                System.out.println("-1. Закончить");
                                w = keyboard.nextLong();
                                Oborydovanie oborydovanie = oborydovanieMenu.singleOborydovanie(w);
                                oborydovanie.setId_kab(0L);
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
                                oborydovanie.setId_kab(id);
                                serviceOborydovanie.update(oborydovanie);
                            }while (w>0);
                        }
                        case 0 -> changeKabinet();
                    }

                }
                case 3->{
                    otdelMenu.drawOtdelList();
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


    void newKabinet() throws SQLException {
        System.out.println("--- Введите данные ---");
        System.out.println("Название кабинета: ");
        String name = keyboard.next();

        otdelMenu.drawOtdelList();
        System.out.print("Выберите в каком отделе будет кабинет: ");
        Long id_otdel = keyboard.nextLong();
        Otdel otdel = otdelMenu.drawSingleOtdel(id_otdel);
        String ot = otdel.getName();

        Kabinet kabinet = new Kabinet(null,name,id_otdel,ot);
        serviceKabinet.save(kabinet);
    }
    void deleteKabinet() throws SQLException {
        otdelMenu.drawOtdelList();
        System.out.print("Выберите отдел:");
        Long id_otdel= keyboard.nextLong();

        drawKabinetList(id_otdel);
        System.out.println("Выберите какой кабинет зотите удалить: ");
        Long id= keyboard.nextLong();
        Kabinet kabinet = drawSingleKabinet(id);
        serviceKabinet.delete(kabinet);
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
}
