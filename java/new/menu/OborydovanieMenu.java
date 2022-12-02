package menu;

import domain.Oborydovanie;
import repository.SQLOborydovanieRepository;
import service.Service;
import service.ServiceOborydovanie;

import java.sql.SQLException;
import java.util.Scanner;

public class OborydovanieMenu {

    Service<Oborydovanie> serviceOborydovanie = new ServiceOborydovanie(new SQLOborydovanieRepository());
    private OtdelMenu otdelMenu;
    private PalatMenu palatMenu;
    private KabinetMenu kabinetMenu;
    private Menu menu;

    Scanner keyboard = new Scanner(System.in);


    void drawOborydovanie() throws SQLException {
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

            case 0-> menu.draw();
            default -> System.out.println("Нет такого поля!!!");
        }
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

                        kabinetMenu.drawListKabinetPoOtdel();
                        System.out.println("В данный момент находится");
                        kabinetMenu.drawSingleKabinet( oborydovanie.getId_kab() );
                        System.out.println("Выберите новый кабинет");
                        oborydovanie.setId_kab(keyboard.nextLong() );

                    }else {
                        System.out.println("Сначало удалите палату!!!");
                    }
                }
                case 4->{
                    if(oborydovanie.getId_kab() == 0){

                        palatMenu.drawListPalatPoOtdel();
                        System.out.println("В данный момент находится");
                        palatMenu.drawSinglePalat( oborydovanie.getId_kab() );
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

    void newOborydovanie() throws SQLException {
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
                otdelMenu.drawOtdelList();
                System.out.print("Выберите отдел:");
                palatMenu.drawPalatList( keyboard.nextLong() );
                System.out.print("Выберите палату:");
                id_palat = keyboard.nextLong();
            }
            case 2->{
                otdelMenu.drawOtdelList();
                System.out.print("Выберите отдел:");
                kabinetMenu.drawKabinetList( keyboard.nextLong() );
                System.out.print("Выберите кабинет: ");
                id_kab = keyboard.nextLong();
            }
            case 3->{

            }
        }
        Oborydovanie oborydovanie = new Oborydovanie(null,name,number,id_kab,id_palat);
        serviceOborydovanie.save(oborydovanie);
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
    Oborydovanie singleOborydovanie(Long id) throws SQLException {
        return serviceOborydovanie.getById(id);
    }
    void deleteOborydovanie() throws SQLException {
        drawOborydovanieList();
        System.out.print("Выберите какое оборудование удалить :");
        Oborydovanie oborydovanie = drawSingleOborydovanie( keyboard.nextLong() );
        serviceOborydovanie.delete( oborydovanie );
    }

    void drawOborydovaniePoIdKab(Long id) throws SQLException {
        serviceOborydovanie.listPoId(id).forEach(System.out::println);
    }
    void drawOborydovaniePoIdPalat(Long id) throws SQLException {
        serviceOborydovanie.getListPoId(id).forEach(System.out::println);
    }
}
